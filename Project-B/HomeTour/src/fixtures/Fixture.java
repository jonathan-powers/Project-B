package fixtures;

public abstract class Fixture {
	
	private String name;
	
	private String shortDesc;
	
	private String longDesc;
	
	public Fixture(String name, String shortDesc, String longDesc) {
		
		this.name = name;
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
	}

	public String getname() {
		return this.name;
	}
	public String getshortDesc() {
		return this.shortDesc;
	}
	public String getlongDesc() {
		return this.longDesc;
	}

}
