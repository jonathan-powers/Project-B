package fixtures;

public class Room extends Fixture{
	
	public Room[] exits;
	
	private Thing[] interior;
	
	public Room(String name, String shortDesc, String longDesc) {
		super(name, shortDesc, longDesc);
		
	}
	
	public Room[] getExits() {
		return this.exits;
	}
	
	public Room getExit(String direction) {
		switch (direction) {
		case "north":
			return this.exits[0];
		case "east":
			return this.exits[1];
		case "south":
			return this.exits[2];
		case "west":
			return this.exits[3];	
		default:
			//System.out.println("that is not a valid direction");
			return this;
		}
	}

	public Thing[] getInterior() {
		return this.interior;
	}

}
