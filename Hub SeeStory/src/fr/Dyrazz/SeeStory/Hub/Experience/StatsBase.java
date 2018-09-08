package fr.Dyrazz.SeeStory.Hub.Experience;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import fr.Dyrazz.SeeStory.Hub.Main;
import fr.Dyrazz.SeeStory.Hub.tools.DataBase;

public class StatsBase {
	
	private static Main plugin;
	
	private static DataBase dataExp = new DataBase();
	private static DataBase dataLevel = new DataBase();
	private static DataBase dataMoney = new DataBase();
	private static DataBase dataVip = new DataBase();
	
	public StatsBase(Main instance) {
		plugin = instance;
	}
	
	public static Main getPlugin() {
		return plugin;
	}
	
	public static int initStats(UUID idPlayer, String playerName, int expAmount, int levelAmount, int moneyAmount, int vipAmount) {
		int a = dataExp.init(idPlayer, playerName, expAmount);
		dataLevel.init(idPlayer, playerName, levelAmount);
		dataMoney.init(idPlayer, playerName, moneyAmount);
		dataVip.init(idPlayer, playerName, vipAmount);
		
		return a;
	}
	
	public static int getExp(UUID idPlayer) {
		return dataExp.getAmount(idPlayer);
	}
	
	public static int getExp(String playerName) {
		return dataExp.getAmount(playerName);
	}
	
	public static int getLevel(UUID idPlayer) {
		return dataLevel.getAmount(idPlayer);
	}
	
	public static int getLevel(String playerName) {
		return dataLevel.getAmount(playerName);
	}
	
	public static int getMoney(UUID idPlayer) {
		return dataMoney.getAmount(idPlayer);
	}
	
	public static int getMoney(String playerName) {
		return dataMoney.getAmount(playerName);
	}
	
	public static int getVip(UUID idPlayer) {
		return dataVip.getAmount(idPlayer);
	}
	
	public static int getVip(String playerName) {
		return dataVip.getAmount(playerName);
	}
	
	public void saveData(String fileName) {
		String path = "";
		{
			File f = new File(System.getProperty("java.class.path"));
			File dir = f.getAbsoluteFile().getParentFile();
			path = dir.toString() + "\\Hub\\";
		}
		String data = "test";
		for (int i = 0; i < dataExp.size(); i++)
			data += dataExp.
		
		try {
			FileOutputStream saveFile = new FileOutputStream(path + fileName + ".data");
			saveFile.write(data.getBytes());
			saveFile.close();
		} catch (Exception e) {
			
		}
		
	}
	
	
}
