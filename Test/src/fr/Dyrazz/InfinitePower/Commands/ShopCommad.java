package fr.Dyrazz.InfinitePower.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

import fr.Dyrazz.InfinitePower.CustomItemStack;


public class ShopCommad implements Listener, CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		Player player = (Player) sender;
		Inventory shopInventory = Bukkit.createInventory(null, 9, "§9              Boutique");
		{
			shopInventory.setItem(2, new CustomItemStack().createItem(Material.CLAY_BALL, "§7Boutique bronze"));
			shopInventory.setItem(3, new CustomItemStack().createItem(Material.IRON_INGOT, "§fBoutique argent"));
			shopInventory.setItem(4, new CustomItemStack().createItem(Material.GOLD_INGOT, "§6Boutique or"));
			shopInventory.setItem(5, new CustomItemStack().createItem(Material.DIAMOND, "§3Boutique diamand"));
			shopInventory.setItem(6, new CustomItemStack().createItem(Material.NETHER_STAR, "§5Boutique anti-matière"));
		}
			player.openInventory(shopInventory);
		return true;
	}
	
	public static void createShopInventory(int id) {
		switch (id) {
			case 0:
				
		}
	}
}
