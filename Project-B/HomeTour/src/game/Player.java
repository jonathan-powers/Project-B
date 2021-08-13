package game;

import fixtures.*;

public class Player {
	
	public Room currentRoom;
	
	public String getCurrentRoom() {
		return currentRoom.getname();
	}
	
	public void setCurrentRoom(Room newRoom) {
		this.currentRoom = newRoom;
	}

}
