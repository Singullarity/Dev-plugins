package fr.Dyrazz.DataBase.Events;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import fr.Dyrazz.DataBase.Main;


public class EventsCosmetics implements Listener{
	public static double x, y, z;
	public static double pointAccount;
	public static double i;
	public static double turns;
	public static double iRadius;
	public static double fRadius;
	@EventHandler
	public void onLeftClickCosmetics(PlayerInteractEvent event) {
		/*
		i = 0;
		p = event.getPlayer();
		Action action = event.getAction();
		ItemStack stack = event.getItem();
		x = p.getLocation().getX();
		y = p.getLocation().getY();
		z = p.getLocation().getZ();
		pointAccount = 100;
		turns = 3;
		radius = 1d;
		if (stack == null && (action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK)) {	
			new BukkitRunnable() {
				@Override
				public void run() {
					EventsCosmetics.p.spawnParticle(Particle.FLAME, EventsCosmetics.x + radius * Math.cos(2 * turns * Math.PI * EventsCosmetics.i / EventsCosmetics.pointAccount), EventsCosmetics.y + 2.25 * EventsCosmetics.i / EventsCosmetics.pointAccount, EventsCosmetics.z + radius * Math.sin(2 * turns * Math.PI * EventsCosmetics.i / EventsCosmetics.pointAccount), 1, 0, 0, 0, 0);
					EventsCosmetics.p.spawnParticle(Particle.FLAME, EventsCosmetics.x + radius * Math.cos(2 * turns * Math.PI * EventsCosmetics.i/ EventsCosmetics.pointAccount + Math.PI), EventsCosmetics.y + 2.25 * EventsCosmetics.i / EventsCosmetics.pointAccount, EventsCosmetics.z + radius * Math.sin(2 * turns * Math.PI * EventsCosmetics.i/ EventsCosmetics.pointAccount + Math.PI), 1, 0, 0, 0, 0);
					if (i == pointAccount - 1)
						this.cancel();
					else
						i++;
				}
			}.runTaskTimer(Main.getPlugin(), 0, 0);
		}
		*/
	}
	
	public static void runCircularParticules(Player p, Particle par, double p_pointAccount, double p_turns, double p_iRadius, double p_fRadius) {
		pointAccount = p_pointAccount;
		turns = p_turns;
		iRadius = p_iRadius;
		fRadius = p_fRadius - p_iRadius;
		i = 0;
		x = p.getLocation().getX(); y = p.getLocation().getY(); z = p.getLocation().getZ();
		new BukkitRunnable() {
			@Override
			public void run() {
				p.spawnParticle(par, x + (iRadius + fRadius * i / pointAccount) * Math.cos(2 * turns * Math.PI * i / pointAccount), y + 2.25 * i / pointAccount, x + (iRadius + fRadius * i / pointAccount) * Math.sin(2 * turns * Math.PI * i / pointAccount), 1, 0, 0, 0, 0);
				p.spawnParticle(par, x + (iRadius + fRadius * i / pointAccount) * Math.cos(2 * turns * Math.PI * i / pointAccount + Math.PI), y + 2.25 * i / pointAccount, x + (iRadius + fRadius * i / pointAccount) * Math.sin(2 * turns * Math.PI * i / pointAccount + Math.PI), 1, 0, 0, 0, 0);
				if (i == pointAccount - 1)
					this.cancel();
				else
					i++;
			}
		}.runTaskTimer(Main.getPlugin(), 0, 0);
	}
	
}