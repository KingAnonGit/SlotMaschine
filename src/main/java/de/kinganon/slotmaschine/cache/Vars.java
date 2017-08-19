package de.kinganon.slotmaschine.cache;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Vars {
    
    public static String prefix = "§e[§bKnockIt§e]§b »§e ";
    public static HashMap<Player, Inventory> lotteries = new HashMap<>();
    
    public static int randInt(int minimum, int maximum) {
        Random rn = new Random();
        int range = maximum - minimum + 1;
        int randomNum = rn.nextInt(range) + minimum;
        return randomNum;
    }
}
