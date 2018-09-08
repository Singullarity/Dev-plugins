package fr.Dyrazz.InfinitePower;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class CustomItemStack {
	public ItemStack createItem(Material material, String name) {
		ItemStack temp = new ItemStack(material, 1);
		ItemMeta meta = temp.getItemMeta();
		meta.setDisplayName(name);
		temp.setItemMeta(meta);
		return temp;
	}
}
