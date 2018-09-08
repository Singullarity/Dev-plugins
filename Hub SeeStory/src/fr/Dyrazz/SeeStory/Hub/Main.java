package fr.Dyrazz.SeeStory.Hub;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import fr.Dyrazz.SeeStory.Hub.Experience.StatsBase;
import fr.Dyrazz.SeeStory.Hub.tools.DataBase;



public class Main extends JavaPlugin implements Listener {
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		DataBase test = new DataBase();
		Player player = event.getPlayer();
		switch (StatsBase.initStats(player.getUniqueId(), player.getName(), 0, 1, 0, 0)) {
			case 0:
				player.sendMessage("Bienvenue " + player.getName() + " sur ce serveur\n");
				test.saveData("exp");
				break;
			case 1:
				player.sendMessage("Tu nouveau pseudo est sympa ;)");
				break;
			case -1:
				player.sendMessage(player.getName() + " Vip " + StatsBase.getVip(player.getUniqueId() +
									"\nNiveau " + StatsBase.getLevel(player.getUniqueId()) +
									"\nExp " + StatsBase.getExp(player.getUniqueId()) + " / " + (int)( (float)( (1 / 4) * Math.pow(StatsBase.getLevel(player.getUniqueId()), 1.75d) + 50 ) ) +
									"\n" + StatsBase.getMoney(player.getUniqueId()) + "€"));
				break;
		}
	}
}
