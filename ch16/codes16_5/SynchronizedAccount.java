package codes16_5;

public class SynchronizedAccount {
	private String accountNo;
	private double balance;
	private boolean flag = false;
	
	public SynchronizedAccount(String accountNo, double balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public synchronized void draw(double drawAmount) throws InterruptedException{
		if(!flag){
			wait();
		}else{
			System.out.println(Thread.currentThread().getName()+"�_ʼȡ�X!���~: "+drawAmount);
			balance = balance - drawAmount;
			System.out.println("�����N�~: "+this.getBalance());
			flag = false;
			notifyAll();
		}
	}
	
	public synchronized void deposit(double depositAmount) throws InterruptedException{
		if(flag){
			wait();
		}else{
			System.out.println(Thread.currentThread().getName()+"�_ʼ���X!���~: "+depositAmount);
			balance = balance + depositAmount;
			System.out.println("�����N�~: "+this.getBalance());
			flag = true;
			notifyAll();
		}
	}
	
	
	
}
