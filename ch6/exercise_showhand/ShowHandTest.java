package exercise_showhand;

public class ShowHandTest {

	/**
	 * @author JianJian
	 * To test the function of ShowHand
	 */
	public static void main(String[] args) {
		ShowHand sh = new ShowHand();
		sh.resetAndStart();
		sh.sendCard();
		sh.sendCard();
		sh.sendCard();
		sh.player1.giveUp();
		sh.sendCard();
		sh.sendCard();
		sh.sendCard();
		sh.sendCard();
		
		sh.resetAndStart();
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
