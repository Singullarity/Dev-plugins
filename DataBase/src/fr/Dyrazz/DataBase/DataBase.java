package fr.Dyrazz.DataBase;

import java.util.ArrayList;

public class DataBase {
	private ArrayList<String> playersName = new ArrayList<String>();
	private ArrayList<Stats> playersStats = new ArrayList<Stats>();
	
	public void add(String playerName) {
		for (int i = 0; i < playersName.size(); i++) {
			if (playerName.equalsIgnoreCase(playersName.get(i)))
				return;
		}
		playersName.add(playerName);
		playersStats.add(new Stats());
	}
	
	public void setStat(String playerName, Stats.statName stat, int value) {
		for (int i = 0; i < playersName.size(); i++) {
			if (playerName.equalsIgnoreCase(playersName.get(i))) {
				playersStats.get(i).setStat(stat, value);
				return;
			}
		}
	}
	
	public int getStat(String playerName, Stats.statName stat) {
		for (int i = 0; i < playersName.size(); i++) {
			if (playerName.equalsIgnoreCase(playersName.get(i))) {
				return playersStats.get(i).getStat(stat);
			}
		}
		return -1;
	}
	
	
}
