package codes16_6;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest3 {
//TODO
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Double> bq = new ArrayBlockingQueue<Double>(1);
//		bq.put(1000.00);
//		System.out.println(bq);
		Account account = new Account("12345",0);
//		DrawThread target = new DrawThread(account,bq);
		DespoitThread target2 = new DespoitThread(account,bq,1000.00);
//		Thread t1 = new Thread(target,"取钱线程1");
//		Thread t2 = new Thread(target,"取钱线程2");
		Thread t3 = new Thread(target2,"存钱线程1");
//		Thread t4 = new Thread(target2,"存钱线程2");
//		t1.start();
//		t2.start();
		t3.start();
//		t4.start();
	}
}

class Account{
	private String accountNo;
	private double balance;
	public Account(String accountNo, double balance) {
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
	
	public void drawAccount(double amount){
		if(balance>=amount){
			System.out.println(Thread.currentThread().getName()+" 取出存款: "+amount);
			balance = balance - amount;
			System.out.println("账户余额: "+balance);
		}else{
			System.out.println("余额不足!");
		}
	}
	
	public void despoit(double amount){
		balance = balance + amount;
		System.out.println(Thread.currentThread().getName()+" 存入账户: "+amount);
	}
	
}

class DrawThread implements Runnable{
	private Account account;
	private double amount;
	private BlockingQueue<Double> bq;
	
	public DrawThread(Account account, BlockingQueue<Double> bq) {
		super();
		this.account = account;
		this.bq = bq;
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			try {
				amount = bq.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			account.drawAccount(amount);
			System.out.println("!!!!"+bq);
		}
	}
}

class DespoitThread implements Runnable{
	private Account account;
	private double amount;
	private BlockingQueue<Double> bq;
	
	public DespoitThread(Account account, BlockingQueue<Double> bq, double amount) {
		super();
		this.bq = bq;
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			try{
				bq.put(amount);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
//			account.despoit(amount);
			System.out.println("???"+bq);
		}
	}
}