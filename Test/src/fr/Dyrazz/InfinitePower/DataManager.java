package fr.Dyrazz.InfinitePower;

public class DataManager {
	
	private static Main plugin = MoneyBase.getPlugin();
	
	public static void saveBalances() {
		for (String playerName : MoneyBase.getBalanceData(0).keySet()) {
			plugin.getConfig().set("bronzeBalance." + playerName, MoneyBase.getBalanceData(0).get(playerName));
			plugin.getConfig().set("silverBalance." + playerName, MoneyBase.getBalanceData(1).get(playerName));
			plugin.getConfig().set("goldBalance." + playerName, MoneyBase.getBalanceData(2).get(playerName));
			plugin.getConfig().set("diamondBalance." + playerName, MoneyBase.getBalanceData(3).get(playerName));
			plugin.getConfig().set("antimatterBalance." + playerName, MoneyBase.getBalanceData(4).get(playerName));
		}
		
		plugin.saveConfig();
	
	}
	
	public static void loadBalances() {
		if (!plugin.getConfig().contains("bronzeBalance") &&
				!plugin.getConfig().contains("silverBalance") &&
				!plugin.getConfig().contains("goldBalance") &&
				!plugin.getConfig().contains("diamondBalance") &&
				!plugin.getConfig().contains("antimatterBalance"))
		return;
		for (String playerName : plugin.getConfig().getConfigurationSection("bronzeBalance").getKeys(false)) {
			MoneyBase.setBalance(playerName, 0, (float) (plugin.getConfig().getDouble("bronzeBalance." + playerName)));
			MoneyBase.setBalance(playerName, 1, (float) (plugin.getConfig().getDouble("silverBalance." + playerName)));
			MoneyBase.setBalance(playerName, 2, (float) (plugin.getConfig().getDouble("goldBalance." + playerName)));
			MoneyBase.setBalance(playerName, 3, (float) (plugin.getConfig().getDouble("diamondBalance." + playerName)));
			MoneyBase.setBalance(playerName, 4, (float) (plugin.getConfig().getDouble("antimatterBalance." + playerName)));
		}
	}
}
