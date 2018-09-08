package fr.Dyrazz.DataBase;

public class Stats {
	private int[] stats = new int[2];
	
	public static enum statName {
		correctHitSword,
		badHitSword
	}
	
	public void init() {
		stats[0] = 0;
		stats[1] = 0;
	}
	
	public void setStat(statName stat, int value) {
		switch (stat) {
			case correctHitSword:
				stats[0] = value;
				return;
			case badHitSword:
				stats[1] = value;
				return;
		}
	}
	
	public int getStat(statName stat) {
		switch (stat) {
			case correctHitSword:
				return stats[0];
			case badHitSword:
				return stats[1];
		}
		return 0;
	}
}
