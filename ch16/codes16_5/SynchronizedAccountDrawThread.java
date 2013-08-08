package codes16_5;

public class SynchronizedAccountDrawThread implements Runnable{
	private SynchronizedAccount account;
	private double drawAmount;
	private int count;
	
	
	public SynchronizedAccountDrawThread(SynchronizedAccount account,
			double drawAmount) {
		super();
		this.account = account;
		this.drawAmount = drawAmount;
	}

	@Override
	public void run() {
		try {
			for(int i=0;i<15;i++){
				account.draw(drawAmount);
				count++;
				System.out.println(count);
			}
			System.out.println(count);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
