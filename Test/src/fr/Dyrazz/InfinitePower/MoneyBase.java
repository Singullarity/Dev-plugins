package fr.Dyrazz.InfinitePower;

import java.util.HashMap;

public class MoneyBase {
	
	private static Main plugin;
	
	private static HashMap<String, Float> BronzeBalance = new HashMap<>();
	private static HashMap<String, Float> SilverBalance = new HashMap<>();
	private static HashMap<String, Float> GoldBalance = new HashMap<>();
	private static HashMap<String, Float> DiamondBalance = new HashMap<>();
	private static HashMap<String, Float> AntiMatterBalance = new HashMap<>();
	
	public MoneyBase(Main instance) {
		plugin = instance;
	}
	
	public static Main getPlugin() {
		return plugin;
	}
	
	public static void playerInit(String playerName) {
		BronzeBalance.put(playerName, 0f);
		SilverBalance.put(playerName, 0f);
		GoldBalance.put(playerName, 0f);
		DiamondBalance.put(playerName, 0f);
		AntiMatterBalance.put(playerName, 0f);
	}
	
	public static String playerMoneyMessage(String playerName) {
		String bronze = " bronze", silver = " argent", gold = " or", diamond = " diamand", antimatter = " anti-matière";
		if (BronzeBalance.get(playerName) > 1f)
			bronze += "s";
		if (SilverBalance.get(playerName) > 1f)
			silver += "s";
		if (GoldBalance.get(playerName) > 1f)
			gold += "s";
		if (DiamondBalance.get(playerName) > 1f)
			diamond += "s";
		if (AntiMatterBalance.get(playerName) > 1f)
			antimatter += "s";
		return "---------------[BANQUE]---------------" +
				"\n" + playerName + " account :" +
				"\n - " + BronzeBalance.get(playerName) + bronze +
				"\n - " + SilverBalance.get(playerName) + silver +
				"\n - " + GoldBalance.get(playerName) + gold +
				"\n - " + DiamondBalance.get(playerName) + diamond +
				"\n - " + AntiMatterBalance.get(playerName) + antimatter +
				"\n--------------------------------------";
	}
	public static void setBalance(String playerName, int type, float amount) {
		switch (type) {
			case 0: 
				BronzeBalance.put(playerName, amount);
				return;
			case 1:
				SilverBalance.put(playerName, amount);
				return;
			case 2:
				GoldBalance.put(playerName, amount);
				return;
			case 3:
				DiamondBalance.put(playerName, amount);
				return;
			case 4:
				AntiMatterBalance.put(playerName, amount);
				return;
		}
	}
	
	public static float getBalance(String playerName, int balanceType) {
		switch (balanceType) {
			case 0:
				return BronzeBalance.get(playerName);
			case 1:
				return SilverBalance.get(playerName);
			case 2:
				return GoldBalance.get(playerName);
			case 3:
				return DiamondBalance.get(playerName);
			case 4:
				return AntiMatterBalance.get(playerName);
			default:
				return 0f;
		}
	}
	
	public static HashMap<String, Float> getBalanceData(int balanceType) {
		switch (balanceType) {
			case 0:
				return BronzeBalance;
			case 1:
				return SilverBalance;
			case 2:
				return GoldBalance;
			case 3:
				return DiamondBalance;
			case 4:
				return AntiMatterBalance;
			default:
				return new HashMap<>();
		}
	}
}
