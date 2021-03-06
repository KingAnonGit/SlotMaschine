package de.kinganon.slotmaschine.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.kinganon.slotmaschine.cache.Variables;
import de.kinganon.slotmaschine.inventorys.SlotMaschineInventory;

public class inventoryClickEvent implements Listener {
    
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getInventory() == player.getInventory()) {
            event.setCancelled(false);
        } else if (event.getInventory().equals(Variables.lotteries.get(player))) {
            if (event.getCurrentItem().getItemMeta() != null
                    && event.getCurrentItem().getItemMeta().getDisplayName() != null && event.getCurrentItem() != null) {
                String name = event.getCurrentItem().getItemMeta().getDisplayName();
                if (name == "§eLos!") {
                    SlotMaschineInventory.createLotteryInventory(player);
                    player.openInventory(Variables.lotteries.get(player));
                } else {
                    event.setCancelled(true);
                }
            } else {
                event.setCancelled(true);
            }
        }
    }
}
