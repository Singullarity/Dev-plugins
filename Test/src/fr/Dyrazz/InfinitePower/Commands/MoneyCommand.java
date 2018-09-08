package fr.Dyrazz.InfinitePower.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.Dyrazz.InfinitePower.MoneyBase;

public class MoneyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		//if (args.length < 2)
			//sender.sendMessage(ChatColor.RED + "Syntaxe correcte : /money + <see/info/set(for admins)> <nomDuJoueur> <type> <quantité>");
		if (args[0].equalsIgnoreCase("see")) {
			if (args[1].equalsIgnoreCase(sender.getName())) {
				//if (sender.hasPermission("InfinitePower.economy.see"))
					sender.sendMessage(ChatColor.GOLD + MoneyBase.playerMoneyMessage(args[1]));
				//else
					//sender.sendMessage(ChatColor.RED + MoneyBase.playerMoneyMessage("Si tu veux voir les comptes des autres, il te faut une permission"));
			}
			else
				sender.sendMessage(ChatColor.GOLD + MoneyBase.playerMoneyMessage(args[1]));
		} else if (args[0].equalsIgnoreCase("info")) {
			sender.sendMessage(ChatColor.GREEN +"Pour obtenir de l'anti-matière :" +
												"\n - télécharge l'application MinerGate" +
												"\n - Connecte toi avec cet id : dyrazz-@hotmail.com" +
												"\n - 0.00005 ETC = 1 antimatière + 0.1 à tous tes amis" +
												"\n - 0.00005 ETH = 2.5 antimatière + 0.5 à tous tes amis" +
												"\n - Ratio (ETC ou ETH)/sec augemente plus vous minez");
		} else if (args[0].equalsIgnoreCase("set")) {
			//if (sender.hasPermission("InfinitePower.economy.admin")) {
				MoneyBase.setBalance(sender.getName(), Integer.parseInt(args[2]), Float.valueOf(args[3]));
				sender.sendMessage(ChatColor.DARK_GREEN + sender.getName() + " à vu son compte changé" + sender.getName() + args[2] + args[3]);
			//} else
			//	sender.sendMessage(ChatColor.RED + "Il faut être admin pour effectuer cette commande");
		}
		return true;
	}
}
