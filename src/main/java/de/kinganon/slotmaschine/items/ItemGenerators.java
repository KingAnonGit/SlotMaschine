package de.kinganon.slotmaschine.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;


public class ItemGenerators {
    
    public static ItemStack ItemGenerator(Material material, String name) {
        ItemStack itemstack = new ItemStack(material, 1);
        ItemMeta itemmeta = itemstack.getItemMeta();
        itemmeta.setDisplayName(name);
        itemstack.setItemMeta(itemmeta);
        return itemstack;
    }
    
    public static ItemStack ItemGenerator(Material material, String name, List<String> lore) {
        ItemStack itemstack = new ItemStack(material, 1);
        ItemMeta itemmeta = itemstack.getItemMeta();
        itemmeta.setDisplayName(name);
        itemmeta.setLore(lore);
        itemstack.setItemMeta(itemmeta);
        return itemstack;
    }
    
    public static ItemStack ItemGenerator(Material material, String name, Enchantment enchantment, int i) {
        ItemStack itemstack = new ItemStack(material, 1);
        ItemMeta itemmeta = itemstack.getItemMeta();
        itemmeta.setDisplayName(name);
        itemstack.setItemMeta(itemmeta);
        itemstack.addUnsafeEnchantment(enchantment, i);
        return itemstack;
    }
    
    public static ItemStack ItemGenerator(Material material, String name, Enchantment enchantment, int i, List<String> lore) {
        ItemStack itemstack = new ItemStack(material, 1);
        ItemMeta itemmeta = itemstack.getItemMeta();
        itemmeta.setDisplayName(name);
        itemmeta.setLore(lore);
        itemstack.setItemMeta(itemmeta);
        itemstack.addUnsafeEnchantment(enchantment, i);
        return itemstack;
    }
}
