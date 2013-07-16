package exercise_showhand;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeSet;

public class ShowHand {
	int leftCards;
	int round;
	
	TreeSet<Player> players = new TreeSet<Player>();
	LinkedList<String> cards = new LinkedList<String>();
	String[] strs1 = {"ºìÌÒ","ºÚÌÒ","²Ý»¨","·½¿é"};
	String[] strs2 = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	
	Player player1 = new Player("Player1",1); 
	Player player2 = new Player("Player2",3);
	Player player3 = new Player("Player3",2);
	
	
	/*
	 * Reset all players' cards to null and reset the cards
	 */
	public void resetCard(){
		for(Player player:players){
			for(int i=0;i<5;i++){
				player.cards[i]=null;
			}
		}

		cards.clear();
		for(int i=0;i<strs1.length;i++){
			for(int j=0;j<strs2.length;j++){
				cards.add(strs1[i]+strs2[j]);
			}
		}
		Collections.shuffle(cards);
		leftCards = cards.size();
		System.out.println("The "+cards.size()+" card has reset");
	}
	
	/*
	 * Reset all players' points to zero
	 */
	public void resetPoint(){
		for(Player player:players){
			player.total = 0;
		}
		System.out.println("The Point is reset to 0");
	}
	
	/*
	 * Reset all players' to Play
	 */
	public void resetPlayer(){
		for(Player player:players){
			player.isPlay = true;
		}
	}
	
	public void start(){
		players.clear();
		round=1;
		players.add(player1);
		players.add(player2);
		players.add(player3);
		System.out.println("Game start!");
	}
	
	public void resetAndStart(){
		start();
		resetCard();
		resetPoint();
		resetPlayer();
	}
	
	public void sendCard(){
		System.out.println("ROUND: "+round);
		if(round<=5&&round>0){
			for(Player player:players){
				if(player.isPlay == true){
					player.cards[round-1]=cards.getFirst();
					System.out.println(player.name+" cards is: "+Arrays.toString(player.cards));
					cards.removeFirst();
					leftCards = cards.size();
				}
			}
			round=round+1;
		}else{
			System.out.println("The number of left cards: "+leftCards);
			System.out.println("Game over!");
		}
	}
	
	public void showHand(){
		for(Player player:players){
			if(player.isPlay == true){
				System.out.println(player);
			}
		}
		
	}
	
} 
