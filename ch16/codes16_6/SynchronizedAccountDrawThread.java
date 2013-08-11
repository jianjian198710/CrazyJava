package codes16_6;

public class SynchronizedAccountDrawThread implements Runnable{
	private SynchronizedAccount account;
	private double drawAmount;
	
	
	public SynchronizedAccountDrawThread(SynchronizedAccount account,
			double drawAmount) {
		super();
		this.account = account;
		this.drawAmount = drawAmount;
	}

	@Override
	public void run() {
		try {
			for(int i=0;i<100;i++){
				account.draw(drawAmount);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
