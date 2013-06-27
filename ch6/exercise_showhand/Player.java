package exercise_showhand;

public class Player {
	
	String name;
	boolean isPlay = true;
	String[] cards = new String[5];
	int location=0;
	int total=0;
	
	public Player(String name,int location){
		this.name = name;
	}
	
	public void giveUp(){
		this.isPlay = false;
	}
	
	public String toString(){
		return "PlayerName:"+this.name+", isPlay:"+this.isPlay+", location:"+this.location+", cards:"+cards.toString();
	}
	
}
