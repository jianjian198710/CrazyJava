package codes16_5;

import java.util.concurrent.locks.ReentrantLock;
/*
 * (1)通过顯式定義同步鎖對象來是實現同步
 * (2)Lock,ReadWriteLock是Java 5新提供的兩個跟接口,并為Lock提供了ReentrantLock實現類,為ReadWriteLock提供了ReentrantReadWriteLock
 * (3)一個線程可以對已被加鎖的ReentrantLock鎖再次加鎖,ReentrantLock對象會維持一個計數器來跟蹤lock()方法的嵌套調用
 */
public class LockAccount {
	//定義鎖對象
	private final ReentrantLock lock = new ReentrantLock();
	private String accountNo;
	private double balance;
	
	public LockAccount(String accountNo,double balance){
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void draw(double drawAcount){
		//加鎖
		lock.lock();
		try{
			if(balance>=drawAcount){
				System.out.println(Thread.currentThread().getName()+"取钱成功!吐出钞票:"+drawAcount);
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				balance = balance - drawAcount;
				System.out.println("余额为:"+balance);
			}else{
				System.out.println(Thread.currentThread().getName()+"余额不足");
			}
		}finally{
			//釋放鎖
			lock.unlock();
		}
	}
	
	@Override
	public int hashCode(){
		return accountNo.hashCode();
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj==this){
			return true;
		}else if(obj!=null&&obj.getClass()==LockAccount.class){
			LockAccount la = (LockAccount)obj;
			return la.getAccountNo().equals(this.getAccountNo());
		}else{
			return false;
		}
	}
}
