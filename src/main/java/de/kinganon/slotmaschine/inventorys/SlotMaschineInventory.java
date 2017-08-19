package de.kinganon.slotmaschine.inventorys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import de.kinganon.slotmaschine.SlotMaschine;
import de.kinganon.slotmaschine.cache.Vars;
import de.kinganon.slotmaschine.items.ItemGenerators;

public class SlotMaschineInventory {
    
    static HashMap<Player, Integer> integer = new HashMap<>();
    public static Inventory inventory = null;
    static HashMap<Player, Integer> taskID = new HashMap<>();
    
    public static void createLotteryInventory(Player player) {
        if (!Vars.lotteries.containsKey(player)) {
            inventory = Bukkit.createInventory(player, 45, "§4Lotterie");
            for (int i = 0; i < 45; i++) {
                inventory.setItem(i, ItemGenerators.ItemGenerator(Material.STAINED_GLASS_PANE, " "));
            }
            integer.put(player, 0);
            List<ItemStack> itemstack = new ArrayList<>();
            itemstack.add(ItemGenerators.ItemGenerator(Material.BOW, "§6Magic Bow", Enchantment.ARROW_DAMAGE, 4));
            itemstack.add(ItemGenerators.ItemGenerator(Material.DIAMOND_AXE, "§6Magic Axe", Enchantment.DAMAGE_ALL, 5));
            itemstack.add(ItemGenerators.ItemGenerator(Material.DIAMOND_PICKAXE, "§6Fast PickAxe", Enchantment.DIG_SPEED, 10));
            itemstack.add(ItemGenerators.ItemGenerator(Material.DIAMOND_PICKAXE, "§6Diamond PickAxe"));
            itemstack.add(ItemGenerators.ItemGenerator(Material.DIAMOND_SWORD, "§6Diamond Sword"));
            itemstack.add(ItemGenerators.ItemGenerator(Material.DIAMOND_SWORD, "§6Super Sword", Enchantment.DAMAGE_ALL, 10));
            itemstack.add(ItemGenerators.ItemGenerator(Material.DIAMOND_HOE, "§6Super Hoe", Enchantment.DAMAGE_ALL, 10));
            itemstack.add(ItemGenerators.ItemGenerator(Material.DIAMOND_HELMET, "§6Diamond Helmet"));
            itemstack.add(ItemGenerators.ItemGenerator(Material.DIAMOND_CHESTPLATE, "§6NoDamage Chest", Enchantment.PROTECTION_ENVIRONMENTAL, 100));
            inventory.setItem(18, itemstack.get(0));
            inventory.setItem(19, itemstack.get(1));
            inventory.setItem(20, itemstack.get(2));
            inventory.setItem(21, itemstack.get(3));
            inventory.setItem(22, itemstack.get(4));
            inventory.setItem(23, itemstack.get(5));
            inventory.setItem(24, itemstack.get(6));
            inventory.setItem(25, itemstack.get(7));
            inventory.setItem(26, itemstack.get(8));
            
            int item = Vars.randInt(0, itemstack.size() - 1);
            Integer taskIDInteger = Bukkit.getScheduler().scheduleSyncRepeatingTask(SlotMaschine.plugin, new Runnable() {
                @Override
                public void run() {
                    if (integer.get(player) <= 25 + item) {
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
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SlotMaschine.plugin, new Runnable() {
                            @Override
                            public void run() {
                                integer.remove(player);
                                player.getInventory().addItem(inventory.getItem(22));
                                player.closeInventory();
                                Vars.lotteries.remove(player);
                            }
                        }, 50L);
                    }
                }
            }, 5L, 5L);
            taskID.put(player, taskIDInteger);
            Vars.lotteries.put(player, inventory);
        }
    }
}
