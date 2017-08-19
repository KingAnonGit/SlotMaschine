package de.kinganon.slotmaschine;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import de.kinganon.slotmaschine.cache.Vars;
import de.kinganon.slotmaschine.events.inventoryClickEvent;
import de.kinganon.slotmaschine.events.InteractEvent;
import de.kinganon.slotmaschine.events.JoinEvent;

public class SlotMaschine extends JavaPlugin {
    
    public static Plugin plugin = null;
    
    public void onEnable() {
        plugin = this;
        Bukkit.getPluginManager().registerEvents(new inventoryClickEvent(), this);
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new InteractEvent(), this);
        Bukkit.getConsoleSender().sendMessage(Vars.prefix + "KnockIt wurde erfolgreich Gestartet!");
    }
}
