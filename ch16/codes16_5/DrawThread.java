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
				System.out.println("ȡ�X�ɹ�!ȡ��: "+drawAmount);
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				account.setBalance(account.getBalance()-drawAmount);
				System.out.println("�����N�~: "+account.getBalance());
			}else{
				System.out.println("�N�~����!");
			}
		}
	}
}
