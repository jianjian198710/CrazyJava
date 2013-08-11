package codes16_6;
/*
 * Object��ṩ��wait(),notify(),notifyAll()��춾��̵�ͨ��
 * (1)���ʹ��synchronized���ͬ������,���ԓ�Ĭ�J����this����ͬ���Oҕ��,���Կ�����ͬ��������ʹ��ԓ�����{���@3������
 * (2)���ʹ��synchronized���ͬ�����a�K,ͬ���Oҕ����synchronized����̖��Č���,���Ա��ʹ��ԓ�����{���@3������
 * (3)notify(),������о��̶��ڴ�ͬ���Oҕ���ϵȴ�,�t���x��������һ������,�x���������
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
