package de.kinganon.slotmaschine.inventorys;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import de.kinganon.slotmaschine.SlotMaschine;
import de.kinganon.slotmaschine.cache.Variables;
import de.kinganon.slotmaschine.items.ItemGenerator;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;

public class SlotMaschineInventory {
    
    @Getter
    private static HashMap<Player, Integer> integer = Maps.newHashMap(),
            taskID = Maps.newHashMap();
    
    @Getter
    private static Inventory inventory = null;
    
    public static void createLotteryInventory(Player player) {
        if (!Variables.lotteries.containsKey(player)) {
            inventory = Bukkit.createInventory(player, 45, "§4Lotterie");
            
            ItemGenerator itemGenerator = new ItemGenerator(Material.STAINED_GLASS_PANE, " ");
            
            for (int i = 0; i < 45; i++) {
                inventory.setItem(i, itemGenerator.getItemStack());
            }
            integer.put(player, 0);
            List<ItemStack> itemStackList = Lists.newArrayList();
            
            itemStackList.add(new ItemGenerator(Material.BOW,
                    "§6Magic Bow", Enchantment.ARROW_DAMAGE, 4).getItemStack());
            itemStackList.add(new ItemGenerator(Material.DIAMOND_AXE,
                    "§6Magic Axe", Enchantment.DAMAGE_ALL, 5).getItemStack());
            itemStackList.add(new ItemGenerator(Material.DIAMOND_PICKAXE,
                    "§6Fast PickAxe", Enchantment.DIG_SPEED, 10).getItemStack());
            itemStackList.add(new ItemGenerator(Material.DIAMOND_PICKAXE, "§6Diamond PickAxe").getItemStack());
            itemStackList.add(new ItemGenerator(Material.DIAMOND_SWORD, "§6Diamond Sword").getItemStack());
            itemStackList.add(new ItemGenerator(Material.DIAMOND_SWORD,
                    "§6Super Sword", Enchantment.DAMAGE_ALL, 10).getItemStack());
            itemStackList.add(new ItemGenerator(Material.DIAMOND_HOE,
                    "§6Super Hoe", Enchantment.DAMAGE_ALL, 10).getItemStack());
            itemStackList.add(new ItemGenerator(Material.DIAMOND_HELMET, "§6Diamond Helmet").getItemStack());
            itemStackList.add(new ItemGenerator(Material.DIAMOND_CHESTPLATE,
                    "§6NoDamage Chest", Enchantment.PROTECTION_ENVIRONMENTAL, 100).getItemStack());
            
            Integer slot = 18;
            
            for(ItemStack itemStack : itemStackList) {
                inventory.setItem(slot, itemStack);
                slot += 1;
            }
            
            int item = Variables.randInt(0, itemStackList.size() - 1);
            
            Integer taskIDInteger = Bukkit.getScheduler().scheduleSyncRepeatingTask(SlotMaschine.getSlotMaschine(),
                    () -> {
                if (integer.get(player) <= 25 + item) {
                    // todo: remove this shit
                    ItemStack firstItem = inventory.getItem(18);
                    ItemStack secondItem = inventory.getItem(19);
                    ItemStack thirdItem = inventory.getItem(20);
                    ItemStack fourthItem = inventory.getItem(21);
                    ItemStack fifthItem = inventory.getItem(22);
                    ItemStack sixthItem = inventory.getItem(23);
                    ItemStack sevensItem = inventory.getItem(24);
                    ItemStack eightsItem = inventory.getItem(25);
                    ItemStack lastItem = inventory.getItem(26);
                    
                    inventory.setItem(18, lastItem);
                    inventory.setItem(19, firstItem);
                    inventory.setItem(20, secondItem);
                    inventory.setItem(21, thirdItem);
                    inventory.setItem(22, fourthItem);
                    inventory.setItem(23, fifthItem);
                    inventory.setItem(24, sixthItem);
                    inventory.setItem(25, sevensItem);
                    inventory.setItem(26, eightsItem);
                    
                    Integer in = integer.get(player) + 1;
                    integer.remove(player);
                    integer.put(player, in);
                } else {
                    Bukkit.getScheduler().cancelTask(taskID.get(player));
                    taskID.remove(player);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlotMaschine.getSlotMaschine(), () -> {
						integer.remove(player);
						player.getInventory().addItem(inventory.getItem(22));
						player.closeInventory();
						Variables.lotteries.remove(player);
					}, 50L);
                }
            }, 5L, 5L);
            
            taskID.put(player, taskIDInteger);
            Variables.lotteries.put(player, inventory);
        }
    }
}
