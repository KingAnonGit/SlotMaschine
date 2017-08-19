package de.kinganon.slotmaschine.inventorys;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import de.kinganon.slotmaschine.items.ItemGenerators;

public class ChestInventory {
    
    public static Inventory createChestInventroy(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 45, "§4Lotterie");
        for (int i = 0; i < 45; i++) {
            inventory.setItem(i, ItemGenerators.ItemGenerator(Material.STAINED_GLASS_PANE, " "));
        }
        List<String> list = new ArrayList<String>();
        list.add("§eGewinne jetzt viele Tolle Preise!");
        inventory.setItem(22, ItemGenerators.ItemGenerator(Material.ENCHANTMENT_TABLE, "§eLos!", list));
        return inventory;
    }
}
