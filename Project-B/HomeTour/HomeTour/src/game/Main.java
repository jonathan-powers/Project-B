package game;

import java.util.Scanner;

import fixtures.*;

public class Main {
	
	public static Scanner userinput;
	
	private static boolean exitprogram;
	
	public static Player player;

	private static RoomManager roomManager;

	public static void main(String[] args) {
		userinput = new Scanner(System.in);
		
		System.out.println("Welcome to HouseTour");
		
		player = new Player();
		
		roomManager= new RoomManager();
		
		exitprogram = false;
		
		roomManager.init();
		
		while (Main.exitprogram == false) {
			System.out.println("What would you like to do?");
			
			String[] input = collectInput();

			Main.parse(input, player);							
		}
		
		userinput.close();
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
				changeRoom(command, player);
			
				break;
			case "examine": case "look":
				look(command, player);
				break;
			case "where":
				printRoom(player);
				break;
			case "quit":
				userinput.close();
				break;
			default:
				break;
			}
		}
		//System.out.println("What?");
	}
	
	private static void changeRoom(String[] command, Player player) {
		for (int i = 0; i < command.length; i++) {
			Room change = player.currentRoom.getExit(command[i]);
			
			if(change != null) {
			
				if (change != player.currentRoom) {
					//need to check if there is an exit
					player.setCurrentRoom(change);
				
					break;
				} 
			}
		}
		//System.out.println("that is not a valid direction");
	}
	
	private static void look(String[] command, Player player) {
		Thing[] things = player.currentRoom.getInterior(); 
		
		for (int i = 0; i < command.length; i++) {
			
			for (int j = 0; j < player.currentRoom.exits.length; j++) {
				
				if(player.currentRoom.exits[j] != null) {
					String obj = player.currentRoom.exits[j].getname();
				
					if(obj.equalsIgnoreCase(command[i])) {
						System.out.println( player.currentRoom.exits[j].getshortDesc());
						break;
					}
				}
			}
			
			for (int j = 0; j < things.length; j++) {
				String obj = things[j].getname(); 
				
				if (obj.equalsIgnoreCase(command[i])) {
					System.out.println(things[j].getlongDesc());
					
					break;
				}
			}
		}
	}
}


