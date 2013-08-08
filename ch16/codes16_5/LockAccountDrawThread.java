package codes16_5;

public class LockAccountDrawThread implements Runnable{

	private LockAccount lockAccount;
	private double drawAccount;
	
	public LockAccountDrawThread(LockAccount lockAccount, double drawAccount) {
		super();
		this.lockAccount = lockAccount;
		this.drawAccount = drawAccount;
	}

	@Override
	public void run() {
		lockAccount.draw(drawAccount);
	}

}
