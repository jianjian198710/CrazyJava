package codes16_6;

public class SynchronizedAccountDepositThread implements Runnable{
	private SynchronizedAccount account;
	private double depositAmount;
	
	
	public SynchronizedAccountDepositThread(SynchronizedAccount account,
			double depositAmount) {
		super();
		this.account = account;
		this.depositAmount = depositAmount;
	}

	@Override
	public void run() {
		try {
			for(int i=0;i<100;i++){
				account.deposit(depositAmount);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
