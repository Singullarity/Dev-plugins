package fr.Dyrazz.DataBase.Commands;

import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dyrazz.DataBase.Events.EventsCosmetics;

public class CommandsParticles implements CommandExecutor {

	public static double x, y, z;
	public static double pointAccount;
	public static double i;
	public static double turns;
	public static double radius;
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		Player p = (Player) sender;
		EventsCosmetics.runParticules(p, Particle.PORTAL, Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));
		return true;
	}

}
