package fr.Dyrazz.InfinitePower;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import fr.Dyrazz.InfinitePower.Commands.MoneyCommand;
import fr.Dyrazz.InfinitePower.Commands.ShopCommad;


public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getCommand("money").setExecutor(new MoneyCommand());
		getCommand("shop").setExecutor(new ShopCommad());
		new MoneyBase(this);
		DataManager.loadBalances();
		System.out.println("[InfinitePower] Plugin enable");
	}
	
	@Override
	public void onDisable() {
		//DataManager.saveBalances();
		System.out.println("[Test] : Plugin disable");
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if (!player.hasPlayedBefore()) {
			MoneyBase.playerInit(player.getName());
			event.setJoinMessage(ChatColor.DARK_AQUA + "[Test] : " + ChatColor.WHITE + "Bienvenue " + player.getName() + " sur ce serveur");
		}
		else
			event.setJoinMessage(ChatColor.GOLD + MoneyBase.playerMoneyMessage(player.getName()));
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack stack = event.getCurrentItem();
		if (stack == null) return;
		if (inv.getName().equalsIgnoreCase("§9              Boutique")) {
			event.setCancelled(true);
			switch(stack.getType()) {
					case CLAY_BALL:
						MoneyBase.setBalance(player.getName(), 0, MoneyBase.getBalance(player.getName(), 0) + 20);
						break;
					default:
						break;
			}
		}
	}
}