package codes16_6;
/*
 * Object類提供的wait(),notify(),notifyAll()用於線程的通信
 * (1)對於使用synchronized修飾的同步方法,因為該類的默認實例this就是同步監視器,所以可以在同步方法中使用該對象調用這3個方法
 * (2)對於使用synchronized修飾的同步代碼塊,同步監視器是synchronized后括號里的對象,所以必須使用該對象調用這3個方法
 * (3)notify(),如果所有線程都在此同步監視器上等待,則會選擇喚醒其中一個線程,選擇是任意的
 * 
 */
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
			System.out.println(Thread.currentThread().getName()+"開始取錢!數額: "+drawAmount);
			balance = balance - drawAmount;
			System.out.println("帳戶餘額: "+this.getBalance());
			flag = false;
			notifyAll();
		}
	}
	
	public synchronized void deposit(double depositAmount) throws InterruptedException{
		if(flag){
			wait();
		}else{
			System.out.println(Thread.currentThread().getName()+"開始存錢!數額: "+depositAmount);
			balance = balance + depositAmount;
			System.out.println("帳戶餘額: "+this.getBalance());
			flag = true;
			notifyAll();
		}
	}
	
	
	
}
