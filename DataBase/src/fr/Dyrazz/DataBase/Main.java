package fr.Dyrazz.DataBase;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.Dyrazz.DataBase.Stats.statName;
import fr.Dyrazz.DataBase.Commands.CommandsParticles;
import fr.Dyrazz.DataBase.Events.EventsCosmetics;
import fr.Dyrazz.DataBase.Events.EventsStats;



public class Main extends JavaPlugin implements Listener {
	
	private static Plugin instance;
	
	@Override
	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new EventsStats(), this);
		getServer().getPluginManager().registerEvents(new EventsCosmetics(), this);
		getCommand("p").setExecutor(new CommandsParticles());
	}
	
	@Override
	public void onDisable() {
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		EventsStats.data.add(p.getName());
		float goodHit = EventsStats.data.getStat(p.getName(), statName.correctHitSword);
		float badHit = EventsStats.data.getStat(p.getName(), statName.badHitSword);
		p.sendMessage("Coups épée bien : " + (int)(goodHit) +
				"\nMauvais coups épée : " + (int)(badHit));
		if (goodHit > 0 || badHit > 0)
			p.sendMessage(100 * goodHit / (goodHit + badHit) + " %");
		else
			p.sendMessage("0 %");
				
	}
	
	public static Plugin getPlugin() {
		return instance;
	}
}
