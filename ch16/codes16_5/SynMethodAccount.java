package codes16_5;

public class SynMethodAccount {
	private String accountNo;
	private double balance;
	
	public SynMethodAccount(String accountNo, double balance) {
		super();
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
	
	@Override
	public int hashCode(){
		return accountNo.hashCode();
	}
	@Override
	public boolean equals(Object obj){
		if(obj==this){
			return true;
		}
		if(obj!=null&&obj.getClass()==Account.class){
			Account account = (Account)obj;
			return account.getAccountNo().equals(this.getAccountNo());
		}
		return false;
	}
	
	public synchronized double draw(double number){
		if(this.getBalance()>=number){
			System.out.println("È¡³ö: "+number);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			balance = balance-number;
			System.out.println("Ê£Óà: "+this.getBalance());
			return this.getBalance();
		}else{
			System.out.println("Óà¶î²»×ã!");
			return this.getBalance();
		}
	}
}
