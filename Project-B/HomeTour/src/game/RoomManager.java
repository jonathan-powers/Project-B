package game;

import fixtures.*;

public class RoomManager {
	
	public static Room startingRoom;
	
	public static Room room1;
	
	public static Room room2;
	
	public static Room room3;
	
	public static Room room4;
	
	public static Room room5;
	
	public static Room room6;
	
	public static Room room7;
	
	public static Room room8;
	
	public static Room room9;
	
	public static Thing object1;
	
	public static Thing object2;
	
	public static Thing object3;
	
	public static Thing object4;
	
	public static Thing object5;
	
	public static Thing object6;
	
	public static Thing object7;
	
	public static Thing object8;
	
	public static Thing object9;
	
	public static Room[][] rooms;
	
	/*public RoomManager(Room startingRoom,Room[][] rooms) {
		
		this.startingRoom = startingRoom;
		this.rooms = rooms;
	}*/
	
	public void init() {
		
		createrooms();
		
		assignrooms();
		
		createinterior();
		
		assigninterior();
		
		int[] index = new int[2];
		
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				index[0] = i;
				index[1] = j;
				
				exitSetup(rooms, rooms[i][j], index);
			}
			
		}
		
		Main.player.setCurrentRoom(rooms[0][0]);
		
	}
	public static Room[] exitSetup(Room[][] rooms,Room currentroom, int[] index) {

		currentroom.exits = new Room[4];
		
		// need to handle edge/corner rooms
		
		if(index[0] < rooms.length-1) {currentroom.exits[0] = rooms[index[0]+1][index[1]];}
		//assigns north exit to value with same index in next array
		
		if(index[1] < rooms[index[0]].length-1) {currentroom.exits[1] = rooms[index[0]][index[1]+1];}
		//assigns east exit to next index in current array
		
		if(index[0] != 0) {currentroom.exits[2] = rooms[index[0]-1][index[1]];}
		//assign south exit to value with same index in previous array
		
		if(index[1] != 0) {currentroom.exits[3] = rooms[index[0]][index[1]-1];}
		//assign west exit to value previous index in current array

		return currentroom.exits;
	}
	
	public static void createrooms() {
		
		RoomManager.rooms  = new Room[3][3];
		
		RoomManager.room1 = new Room("Room1 name","Room1 short","Room1 long");
		
		RoomManager.room2 = new Room("Room2 name","Room2 short","Room2 long");
		
		RoomManager.room3 = new Room("Room3 name","Room3 short","Room3 long");
		
		RoomManager.room4 = new Room("Room4 name","Room4 short","Room4 long");
		
		RoomManager.room5 = new Room("Room5 name","Room5 short","Room5 long");
		
		RoomManager.room6 = new Room("Room6 name","Room6 short","Room6 long");
		
		RoomManager.room7 = new Room("Room7 name","Room7 short","Room7 long");
		
		RoomManager.room8 = new Room("Room8 name","Room8 short","Room8 long");
		
		RoomManager.room9 = new Room("Room9 name","Room9 short","Room9 long");
	}
	
	public static void assignrooms() {
		rooms[0][0] = room1;
		
		rooms[0][1] = room2;
		
		rooms[0][2] = room3;
		
		rooms[1][0] = room4;
		
		rooms[1][1] = room5;
		
		rooms[1][2] = room6;
		
		rooms[2][0] = room7;
		
		rooms[2][1] = room8;
		
		rooms[2][2] = room9;
	}
	
	public static void createinterior() {
		object1 = new Thing("object1","object1 short","object1 long");
		
		object2 = new Thing("object2","object2 short","object2 long");
		
		object3 = new Thing("object3","object3 short","object3 long");
		
		object4 = new Thing("object4","object4 short","object4 long");
		
		object5 = new Thing("object5","object5 short","object5 long");
		
		object6 = new Thing("object6","object6 short","object6 long");
		
		object7 = new Thing("object7","object7 short","object7 long");

		object8 = new Thing("object8","object8 short","object8 long");
		
		object9 = new Thing("object9","object9 short","object9 long");
	}
	
	public static void assigninterior() {
		room1.interior[0] = object1;
		room1.interior[1] = object2;
		room1.interior[2] = object3;
		
		room2.interior[0] = object2;
		room2.interior[1] = object3;
		room2.interior[2] = object4;
		
		room3.interior[0] = object3;
		room3.interior[1] = object4;
		room3.interior[2] = object5;
		
		room4.interior[0] = object4;
		room4.interior[1] = object5;
		room4.interior[2] = object6;
		
		room5.interior[0] = object5;
		room5.interior[1] = object6;
		room5.interior[2] = object7;
		
		room6.interior[0] = object6;
		room6.interior[1] = object7;
		room6.interior[2] = object8;
		
		room7.interior[0] = object7;
		room7.interior[1] = object8;
		room7.interior[2] = object9;
		
		room8.interior[0] = object8;
		room8.interior[1] = object9;
		room8.interior[2] = object1;
		
		room9.interior[0] = object9;
		room9.interior[1] = object1;
		room9.interior[2] = object2;
	}
}
