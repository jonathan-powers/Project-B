package game;

import java.util.ArrayList;

import fixtures.*;

public class Player {
	
	private Room currentRoom;
	
	private ArrayList<Thing> inv = new ArrayList<Thing>();
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public void setCurrentRoom(Room newRoom) {
		this.currentRoom = newRoom;
		//normal setter
		
		System.out.println("You are now in the" + this.currentRoom.getname());
		//Prints the name of the new room
		
		System.out.println(this.currentRoom.getlongDesc());
		//prints the long description of the new room
		
		System.out.println("The " + this.currentRoom.getname() + " contains:");
		for (int i = 0; i < this.currentRoom.getInv().size(); i++) {
			System.out.println(this.currentRoom.getInv().get(i).getshortDesc());
		}//lists the objects in the interior
		
		String[] direction = {"North","East","South","West"};
		//direction Array
		
		for (int i = 0; i < this.currentRoom.getExits().length; i++) {
			if (this.currentRoom.getExits()[i] != null) {
				//if there is no exit returns null
				
				System.out.println(direction[i] + "Exit: " + this.currentRoom.getExits()[i].getname());
			}//lists the exits to the new room
		}
		
		
	}
	
	public ArrayList<Thing> getInv() {
		return inv;
	}
	
	public void pickup(Thing thing, Room room, Player player) {
		inv.add(thing); // adds the object to the players inventory
		
		room.getInv().remove(thing);// removes the object from the room
	}
	
	public void drop(Thing thing, Room room, Player player) {
		inv.remove(thing); // removes the object from the player's inventory 
		
		room.getInv().add(thing); // adds it to the room
	}

	public void listinv() {
		//method that prints the name of objects in player inventory
		
		for (int i = 0; i < inv.size(); i++) {
			System.out.println(inv.get(i).getname());
		}
		
	}

}
