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
		
		//creates Scanner object to collect input
		
		System.out.println("Welcome to HouseTour");
		
		player = new Player();
		
		//creates the player object
		
		roomManager= new RoomManager();
		
		roomManager.init();
		
		//creates the Room Manager then runs the init method which sets up the 
		//structure of the home, the rooms it contains, and  the things in the room
		
		exitprogram = false;
		
		while (Main.exitprogram == false) {
			System.out.println("What would you like to do?");
			
			String[] input = collectInput();

			Main.parse(input, player);							
		}
		
		// loop that will collect the user input, parse what the input wants to do,
		// then collects the next input until the user inputs "quit"
		
		userinput.close();
	}
		
	private static void printRoom(Player player) {
		// Method that prints the current room
		
		String room = player.getCurrentRoom().getname();
		
		System.out.println(room);
	}

	private static String[] collectInput() {
		String input = userinput.nextLine();
		// stores the user's input as a string
		
		input = input.replaceAll("\\p{Punct}", "");
		// removes punctuation
		
		input = input.toLowerCase();
		// changes all characters to lowers case
		
		return input.split(" ");
		// creates the array of words
	}
		
	private static void parse(String[] command, Player player) {
		//takes the array of words created by collectInput and iterates over each word
		//to see if it matches one of the command keywords, 
		//and if it does runs the associated command
		
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
			case "grab":
				grab(command, player);
				break;
			case "drop": case "place":
				drop(command,player);
				break;
			case "inventory":
				player.listinv();
				break;
			case "quit":
				exitprogram = true;
				
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
			//iterates over the user input to look for a direction
			
			Room change = player.getCurrentRoom().getExit(command[i]);
			//Grabs the room that is the exit in the given direction
			
			if(change != null) {
			//if there isn't an exit in the direction it will return null
				
				if (change != player.getCurrentRoom()) {
					//if the word is not a valid direction it will return the current room
					
					player.setCurrentRoom(change);
					//method that changes the room
					break;
				} 
			}
		}
	}
	
	private static void look(String[] command, Player player) { 
		
		for (int i = 0; i < command.length; i++) {
			//iterates over the words in the user input
			
			for (int j = 0; j < player.getCurrentRoom().getExits().length; j++) {
				//first checks if there is an exit listed in the input 
				
				if(player.getCurrentRoom().getExits()[j] != null) {
					//checks if there is a valid exit
					
					String obj = player.getCurrentRoom().getExits()[j].getname();
				
					if(obj.equalsIgnoreCase(command[i])) {
						//checks if any of exit room names match the input
						
						System.out.println( player.getCurrentRoom().getExits()[j].getshortDesc());
						//outputs a short description of the exit room
						break;
					}
				}
			}
			// checks if the object is in the room
			for (int j = 0; j < player.getCurrentRoom().getInv().size(); j++) {
				String obj = player.getCurrentRoom().getInv().get(j).getname(); 
				
				if (obj.equalsIgnoreCase(command[i])) {
					System.out.println(player.getCurrentRoom().getInv().get(j).getlongDesc());
					
					break;
				}
			}
			//checks the players inventory for the object
			for (int k = 0; k < player.getInv().size(); k++) {
				String obj = player.getInv().get(k).getname();
				
				if (obj.equalsIgnoreCase(command[i])) {
					System.out.println(player.getInv().get(k).getlongDesc());
				}
				
			}
		}
	}
	
	public static void grab(String[] command, Player player) {
		for (int i = 0; i < command.length; i++) {
			//iterates over the words in the user input
			
			for (int j = 0; j < player.getCurrentRoom().getInv().size(); j++) {
				//iterates over the objects in the current room
				
				if(command[i].equalsIgnoreCase(player.getCurrentRoom().getInv().get(j).getname())) {
					//checks if the user input matches any objects in the room
					
					System.out.println("You picked up " + player.getCurrentRoom().getInv().get(j).getname());
					
					player.pickup(player.getCurrentRoom().getInv().get(j), player.getCurrentRoom(), player);
					// adds the object to the players inventory and removes it from the room
				}
			}
		}
	}
	
	public static void drop(String[] command, Player player) {
		for (int i = 0; i < command.length; i++) {
			//iterates over the user input to check for objects
			
			for (int j = 0; j < player.getInv().size(); j++) {
				//iterates over the objects in the players inventory
				
				if(command[i].equalsIgnoreCase(player.getInv().get(j).getname())) {
					//checks if the user input matches any of the objects in the player's inventory
					
					System.out.println("You dropped " + player.getInv().get(j).getname() + " in " + player.getCurrentRoom().getname());
					
					player.drop(player.getInv().get(j), player.getCurrentRoom(), player);
					//removes the object from the players inventory and puts in the room
				}
			}
		}
	}
}


