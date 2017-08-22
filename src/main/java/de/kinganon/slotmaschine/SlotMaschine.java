package de.kinganon.slotmaschine;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.kinganon.slotmaschine.cache.Variables;
import de.kinganon.slotmaschine.events.inventoryClickEvent;
import de.kinganon.slotmaschine.events.InteractEvent;
import de.kinganon.slotmaschine.events.JoinEvent;

public class SlotMaschine extends JavaPlugin {
    
    @Getter
    private static SlotMaschine slotMaschine;
    
    public SlotMaschine() {
        slotMaschine = this;
    }
    
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new inventoryClickEvent(), this);
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new InteractEvent(), this);
        Bukkit.getConsoleSender().sendMessage(Variables.prefix + "KnockIt wurde erfolgreich Gestartet!");
    }
}