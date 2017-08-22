package de.kinganon.slotmaschine.inventorys;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import de.kinganon.slotmaschine.items.ItemGenerator;

public class ChestInventory {
    
    public static Inventory createChestInventroy(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 45, "§4Lotterie");
        
        ItemGenerator itemGenerator = new ItemGenerator(Material.STAINED_GLASS_PANE, " ");
        
        for (int i = 0; i < 45; i++) {
            inventory.setItem(i, itemGenerator.getItemStack());
        }
        List<String> list = new ArrayList<>();
        list.add("§eGewinne jetzt viele Tolle Preise!");
        inventory.setItem(22, new ItemGenerator(Material.ENCHANTMENT_TABLE, "§eLos!", list).getItemStack());
        return inventory;
    }
}
