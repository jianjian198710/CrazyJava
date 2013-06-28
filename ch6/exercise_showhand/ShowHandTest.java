package exercise_showhand;

public class ShowHandTest {

	/**
	 * @author JianJian
	 * To test the function of ShowHand
	 */
	public static void main(String[] args) {
		ShowHand sh = new ShowHand();
		sh.start();
		sh.resetAll();
		sh.sendCard();
		sh.sendCard();
		sh.sendCard();
		sh.player1.giveUp();
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
