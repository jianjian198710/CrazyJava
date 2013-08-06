package codes16_5;

public class SynMethodDrawThread implements Runnable{
	private SynMethodAccount account;
	private double drawAmount;
	
	public SynMethodDrawThread(SynMethodAccount account, double drawAmount) {
		super();
		this.account = account;
		this.drawAmount = drawAmount;
	}
	
	@Override
	public void run(){
		account.draw(drawAmount);
	}

}
