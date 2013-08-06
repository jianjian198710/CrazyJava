package codes16_5;

public class DrawThread implements Runnable{
	private Account account;
	private double drawAmount;
	
	public DrawThread(Account account, double drawAmount) {
		super();
		this.account = account;
		this.drawAmount = drawAmount;
	}

	@Override
	public void run() {
		synchronized(account){
			if(account.getBalance()>=drawAmount){
				System.out.println("取錢成功!取出: "+drawAmount);
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				account.setBalance(account.getBalance()-drawAmount);
				System.out.println("帳戶餘額: "+account.getBalance());
			}else{
				System.out.println("餘額不足!");
			}
		}
	}
}
