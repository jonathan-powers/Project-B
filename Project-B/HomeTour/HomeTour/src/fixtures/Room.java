package fixtures;

import java.util.ArrayList;

public class Room extends Fixture{
	
	public Room[] exits;
	
	private Thing[] interior;
	
	private ArrayList<Thing> inv = new ArrayList<Thing>();
	
	public Room(String name, String shortDesc, String longDesc) {
		super(name, shortDesc, longDesc);
		
		this.interior = new Thing[3];
		
	}
	
	public Room[] getExits() {
		return this.exits;
	}
	
	public Room getExit(String direction) {
		//checks if the given string is a direction
		// if it is return the room in the given direction
		
		switch (direction) {
		case "north": case "up":
			return this.exits[0];
		case "east": case "right":
			return this.exits[1];
		case "south": case "down":
			return this.exits[2];
		case "west": case "left":
			return this.exits[3];	
		default:
			//System.out.println("that is not a valid direction");
			return this;
		}
	}

	public Thing[] getInterior() {
		return this.interior;
	}
	
	public ArrayList<Thing> getInv() {
		return inv;
	}
	
	public void listInv() {
		//method that prints objects in the current Room
		
		for (int i = 0; i < inv.size(); i++) {
			System.out.println(inv.get(i).getname());
		}
		
	}

}
