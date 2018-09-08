package fr.Dyrazz.SeeStory.Hub.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.UUID;

public class DataBase {
	private ArrayList<UUID> idData = new ArrayList<UUID>();
	private ArrayList<String> nameData = new ArrayList<String>();
	private ArrayList<Integer> amountData = new ArrayList<Integer>();
	
	public int init(UUID idPlayer, String playerName, int amount) {
		boolean check = false;
		for (int i = 0; i < idData.size(); i++) {
			if (idPlayer == idData.get(i)) {
				check = true;
				if (playerName != nameData.get(i)) {
					nameData.set(i, playerName);
					return 1;
				}
			}
		}
		if (check == false) {
			idData.add(idPlayer);
			nameData.add(playerName);
			amountData.add(amount);
			return 0;
		}
		return -1;
	}
	
	public UUID getIdPlayer(String playerName) {
		for (int i = 0; i < nameData.size(); i++) {
			if (playerName == nameData.get(i)) {
				return idData.get(i);
			}
		}
		return null;
	}
	
	public String getPlayerName(UUID idPlayer) {
		for (int i = 0; i < idData.size(); i++) {
			if (idPlayer == idData.get(i)) {
				return nameData.get(i);
			}
		}
		return null;
	}
	
	public int getAmount(UUID idPlayer) {
		for (int i = 0; i < idData.size(); i++) {
			if (idPlayer == idData.get(i)) {
				return amountData.get(i);
			}
		}
		return -1;
	}
	
	public int getAmount(String playerName) {
		for (int i = 0; i < nameData.size(); i++) {
			if (playerName == nameData.get(i)) {
				return amountData.get(i);
			}
		}
		return -1;
	}
	
	public ArrayList<UUID> getAllPlayerAmountId(int amount) {
		ArrayList<UUID> idPlayers = new ArrayList<UUID>();
		for (int i = 0; i < amountData.size(); i++) {
			if (amount == amountData.get(i)) {
				idPlayers.add(idData.get(i));
			}
		}
		return idPlayers;
	}
	
	public ArrayList<String> getAllPlayerAmountName(int amount) {
		ArrayList<String> namePlayers = new ArrayList<String>();
		for (int i = 0; i < amountData.size(); i++) {
			if (amount == amountData.get(i)) {
				namePlayers.add(nameData.get(i));
			}
		}
		return namePlayers;
	}
	
}
