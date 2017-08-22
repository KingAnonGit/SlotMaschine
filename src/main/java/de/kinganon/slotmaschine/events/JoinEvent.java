package de.kinganon.slotmaschine.events;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.kinganon.slotmaschine.items.ItemGenerator;

@Getter
public class JoinEvent implements Listener {

	private ItemGenerator itemGenerator;
	
	public JoinEvent() {
		this.itemGenerator = new ItemGenerator(Material.CHEST, "§4Lotterie");
	}
	
	 @EventHandler
	 public void onJoin(PlayerJoinEvent event){
		 Player player = event.getPlayer();
		 player.getInventory().clear();
		 player.getInventory().setItem(4, getItemGenerator().getItemStack());
	 }
}
