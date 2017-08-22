package de.kinganon.slotmaschine.cache;

import java.util.HashMap;
import java.util.Random;

import com.google.common.collect.Maps;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Variables {
    
    public static String prefix = "§e[§bKnockIt§e]§b »§e ";
    public static HashMap<Player, Inventory> lotteries = Maps.newHashMap();
    
    public static int randInt(int minimum, int maximum) {
        Random random = new Random();
        int range = (maximum - minimum) + 1;
        return random.nextInt(range) + minimum;
    }
}
