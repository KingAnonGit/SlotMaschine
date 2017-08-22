package de.kinganon.slotmaschine.events;

import de.kinganon.slotmaschine.cache.Variables;
import de.kinganon.slotmaschine.inventorys.SlotMaschineInventory;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractEvent implements Listener {
    
    // todo: item in hand could be null
    
    @EventHandler
    public static void onInventoryClick(PlayerInteractEvent event) {
        if (event.getPlayer().getItemInHand().getItemMeta() != null
                && event.getPlayer().getItemInHand().getItemMeta().getDisplayName() != null) {
            String name = event.getPlayer().getItemInHand().getItemMeta().getDisplayName();
            if (name == "§4Lotterie") {
                SlotMaschineInventory.createLotteryInventory(event.getPlayer());
                event.getPlayer().openInventory(Variables.lotteries.get(event.getPlayer()));
            }
        }
    }
}