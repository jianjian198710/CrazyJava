package exercise_showhand;

import java.util.Arrays;
import java.util.LinkedList;

public class ShowHand {
	int leftCards;
	int round=1;
	int showHandCard;
	LinkedList<Player> players = new LinkedList<Player>();
	LinkedList<String> cards = new LinkedList<String>();
	
	Player player1 = new Player("Player1",1); 
	Player player2 = new Player("Player2",2);
	Player player3 = new Player("Player3",3);
	
	public void resetCard(){
		for(Player player:players){
			for(int i=0;i<5;i++){
				player.cards[i]=null;
			}
		}

		cards.clear();
		for(int i=1;i<55;i++){
			cards.add(String.valueOf(i));
		}
		leftCards = cards.size();
		System.out.println("The "+cards.size()+" card has reset");
	}
	
	public void resetPoint(){
		for(Player player:players){
			player.total = 0;
		}
		System.out.println("The Point is reset");
	}
	

	public void resetPlayer(){
		for(Player player:players){
			player.isPlay = true;
		}
	}
	
	public void resetAll(){
		resetCard();
		resetPoint();
		resetPlayer();
	}
	
	
	public void start(){
		players.clear();
		round=1;
		players.add(player1);
		players.add(player2);
		players.add(player3);
		System.out.println("Game start!");
	}
	
	public void sendCard(){
		if(round!=0){
			for(Player player:players){
				if(player.isPlay == true){
					player.cards[round-1]=cards.getFirst();
					System.out.println(player.name+" cards is: "+Arrays.toString(player.cards));
					cards.removeFirst();
					leftCards = 54-cards.size();
				}
			}
			round=round+1;
		}else{
			System.out.println("Game over!");
		}
		if(round>=6){
			showHand();
			round=0;
		}
	}
	
	

	
	public void showHand(){
		for(Player player:players){
			if(player.isPlay == true){
				for(int i=0;i<5;i++){
					player.total = Integer.parseInt(player.cards[i])+player.total;
				}
				System.out.println(player.name+" total point is: "+player.total);
			}
		}
		
	}
	
	
	public static void main(String[] args){
		ShowHand sh = new ShowHand();
		sh.start();
		sh.resetAll();
		sh.sendCard();
		sh.sendCard();
		sh.sendCard();
//		sh.player1.giveUp();
		sh.sendCard();
		sh.sendCard();
		sh.sendCard();
		sh.sendCard();
		
		sh.start();
		sh.resetAll();
		sh.sendCard();
		sh.sendCard();
		sh.sendCard();
		sh.sendCard();
		sh.sendCard();
		sh.sendCard();
		sh.sendCard();
		sh.sendCard();
		
	}
} 
