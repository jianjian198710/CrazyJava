package codes16_5;

import java.util.concurrent.locks.ReentrantLock;
/*
 * (1)ͨ���@ʽ���xͬ���i������ǌ��Fͬ��
 * (2)Lock,ReadWriteLock��Java 5���ṩ�ăɂ����ӿ�,����Lock�ṩ��ReentrantLock���F�,��ReadWriteLock�ṩ��ReentrantReadWriteLock
 * (3)һ�����̿��Ԍ��ѱ����i��ReentrantLock�i�ٴμ��i,ReentrantLock������S��һ��Ӌ�������ۙlock()������Ƕ���{��
 */
public class LockAccount {
	//���x�i����
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
		//���i
		lock.lock();
		try{
			if(balance>=drawAcount){
				System.out.println(Thread.currentThread().getName()+"ȡǮ�ɹ�!�³���Ʊ:"+drawAcount);
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				balance = balance - drawAcount;
				System.out.println("���Ϊ:"+balance);
			}else{
				System.out.println(Thread.currentThread().getName()+"����");
			}
		}finally{
			//ጷ��i
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
