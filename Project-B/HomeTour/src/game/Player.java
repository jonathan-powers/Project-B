package game;

import fixtures.*;

public class Player {
	
	public Room currentRoom;
	
	public String getCurrentRoom() {
		return currentRoom.getname();
	}
	
	public void setCurrentRoom(Room newRoom) {
		this.currentRoom = newRoom;
		
		System.out.println("You are now in the" + this.currentRoom.getname());
		
		System.out.println(this.currentRoom.getlongDesc());
		
		System.out.println("The" + this.currentRoom.getname() + "contains:");
		for (int i = 0; i < this.currentRoom.getInterior().length; i++) {
			System.out.println(this.currentRoom.getInterior()[i].getshortDesc());
		}
		
		for (int i = 0; i < this.currentRoom.exits.length; i++) {
			if (this.currentRoom.exits[i] != null) 
			{System.out.println("Exit " + i + ":" + this.currentRoom.exits[i].getname());
			
			}
		}
		
		
	}

}
