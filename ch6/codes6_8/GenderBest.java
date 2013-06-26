package codes6_8;

public enum GenderBest {
	
	MALE("ÄÐ"),FEMALE("Å®");
	private final String name;
	private GenderBest(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}
