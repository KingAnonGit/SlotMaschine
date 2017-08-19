package de.kinganon.slotmaschine.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import de.kinganon.slotmaschine.cache.Vars;
import de.kinganon.slotmaschine.inventorys.SlotMaschineInventory;

public class InteractEvent implements Listener {
	
	@EventHandler
	public static void onInventoryClick(PlayerInteractEvent event) {
		Player player = (Player) event.getPlayer();
		if ( player.getItemInHand().getItemMeta() != null && player.getItemInHand().getItemMeta().getDisplayName() != null ){
		String name = player.getItemInHand().getItemMeta().getDisplayName();
		if ( name == "§4Lotterie" ) {
			SlotMaschineInventory.createLotteryInventory(player);
			player.openInventory(Vars.lotteries.get(player));
		}
}
		}
	}