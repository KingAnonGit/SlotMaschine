package de.kinganon.slotmaschine.items;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

@Getter
public class ItemGenerator {
    
    private ItemStack itemStack;
    
    public ItemGenerator(Material material, String name) {
        itemStack = new ItemStack(material, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemStack.setItemMeta(itemMeta);
    }
    
    public ItemGenerator(Material material, String name, List<String> lore) {
        itemStack = new ItemStack(material, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
    }
    
    public ItemGenerator(Material material, String name, Enchantment enchantment, int i) {
        itemStack = new ItemStack(material, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemStack.setItemMeta(itemMeta);
        itemStack.addUnsafeEnchantment(enchantment, i);
    }
    
    public ItemGenerator(Material material, String name, Enchantment enchantment, int i, List<String> lore) {
        itemStack = new ItemStack(material, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        itemStack.addUnsafeEnchantment(enchantment, i);
    }
}
