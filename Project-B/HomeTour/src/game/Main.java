package game;

import java.util.Scanner;

import fixtures.*;

public class Main {
	
	public static Scanner userinput;
	
	private static boolean exitprogram;
	
	public static Player player;

	public static void main(String[] args) {
		Main.userinput = new Scanner(System.in);
		
		Main.player = new Player();
		
		Main.exitprogram = false;
		
		while (Main.exitprogram == false) {
			String[] input = Main.collectInput();
			for (int i = 0; i < input.length; i++) {
				if (input[i] == "quit") {
					exitprogram = true;
				} else {
					Main.parse(input, Main.player);
				}
			}
		}
		
		Main.userinput.close();
	}
		
	private static void printRoom(Player player) {
		String room = player.getCurrentRoom();
		
		System.out.println(room);
	}

	private static String[] collectInput() {
		String input = userinput.nextLine();
		
		input = input.replaceAll("\\p{Punct}", "");
		// removes punctuation
		
		input = input.toLowerCase();
		// changes all characters to lowers case
		
		return input.split(" ");
		// creates the array of words
	}
		
	private static void parse(String[] command, Player player) {
		for (int i = 0; i < command.length; i++) {
			
			switch (command[i]) {
			case "go": case "move":
				Main.changeRoom(command, player);
			
				break;
			case "examine": case "look":
				Main.look(command, player);
				break;
			case "where":
				Main.printRoom(player);
				break;

			default:
				System.out.println("What?");
				break;
			}
		}
	}
	
	private static void changeRoom(String[] command, Player player) {
		for (int i = 0; i < command.length; i++) {
			Room change = player.currentRoom.getExit(command[i]);
			
			if (change != player.currentRoom) {
				//need to check if there is an exit
				player.setCurrentRoom(change);
				
				break;
			} 
		}
		System.out.println("that is not a valid direction");
	}
	
	private static void look(String[] command, Player player) {
		Thing[] things = player.currentRoom.getInterior(); 
		
		for (int i = 0; i < command.length; i++) {
			for (int j = 0; j < things.length; j++) {
				String obj = things[j].getname(); 
				if (obj.equalsIgnoreCase(command[i])) {
					System.out.println(things[j].getlongDesc());
				}
			}
		}
	}
}


