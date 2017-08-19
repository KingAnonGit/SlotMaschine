package de.kinganon.slotmaschine.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.kinganon.slotmaschine.items.ItemGenerators;

public class JoinEvent implements Listener {

	 @EventHandler
	 public static void onJoin(PlayerJoinEvent event){
		 Player player = event.getPlayer();
		 player.getInventory().clear();
		 player.getInventory().setItem(4, ItemGenerators.ItemGenerator(Material.CHEST, "§4Lotterie"));
	 }
}
