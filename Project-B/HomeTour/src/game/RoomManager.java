package game;

import fixtures.*;

public class RoomManager {
	
	public Room startingRoom;
	
	public Room[][] rooms;
	
	public RoomManager(Room startingRoom,Room[][] rooms) {
		
		this.startingRoom = startingRoom;
		this.rooms = rooms;
	}
	
	public void init() {
		
	}
	public Room[] exitSetup(Room[][] rooms,Room currentroom, int[] roomindex) {

		currentroom.exits = new Room[4];
		
		

		return currentroom.exits;
	}
}
