package fr.Dyrazz.DataBase.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.Dyrazz.DataBase.DataBase;
import fr.Dyrazz.DataBase.Stats.statName;

public class EventsStats implements Listener {
	
	public static DataBase data = new DataBase();
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		Action action = event.getAction();
		ItemStack stack = event.getItem();
		
		if (stack == null)
			return;
		
		if (stack.getType() == Material.WOODEN_SWORD || stack.getType() == Material.STONE_SWORD || stack.getType() == Material.IRON_SWORD || stack.getType() == Material.GOLDEN_SWORD || stack.getType() == Material.DIAMOND_SWORD) {
			if (action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK) {
				data.setStat(p.getName(), statName.badHitSword, data.getStat(p.getName(), statName.badHitSword) + 1);
				p.sendMessage("+ 1 mauvais");
			}
		}
	}
	
	@EventHandler
	public void onDamageDeal(EntityDamageByEntityEvent event) {
		if(event.getDamager() instanceof Player) {
			Player p = (Player) event.getDamager();
			Material item = p.getInventory().getItemInMainHand().getType();
			if (item == null)
				return;
			if (item == Material.WOODEN_SWORD || item == Material.STONE_SWORD || item == Material.IRON_SWORD || item == Material.GOLDEN_SWORD || item == Material.DIAMOND_SWORD) {
				if (event.getEntity() instanceof Player) {
					data.setStat(p.getName(), statName.correctHitSword, data.getStat(p.getName(), statName.correctHitSword) + 1);
					p.sendMessage("+ 1 bon");
				} else {  //modif par badHitSword
					data.setStat(p.getName(), statName.correctHitSword, data.getStat(p.getName(), statName.correctHitSword) + 1);
					p.sendMessage("+ 1 mauvais");
					p.sendMessage("" + data.getStat(p.getName(), statName.correctHitSword));
				}
			}
		}
	}
	
	@EventHandler
	public void onMoving(Player pEvent) {
		if (pEvent.getPlayer().getWorld().getBlockAt(pEvent.getPlayer().getLocation()).getType() == Material.WATER) {
			double x = pEvent.getPlayer().getLocation().getX(), y = pEvent.getPlayer().getLocation().getY(), z = pEvent.getPlayer().getLocation().getZ();
			if (x < 0) x--;
			if (z < 0) z--;
			int i;
			for (i = 0; i < 100; i++) {
				if (pEvent.getPlayer().getWorld().getBlockAt((int) x, (int) y + i, (int) z).getType() != Material.WATER)
					break;
			}
				pEvent.getPlayer().damage((int) (i / 5));
				pEvent.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 5000, (int) (i / 7)));
				pEvent.getPlayer().sendMessage("" + (int) (i / 7));
		}
		if (pEvent.getPlayer().hasPotionEffect(PotionEffectType.SLOW_DIGGING))
			pEvent.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 1, 1));	
		
	}
}
