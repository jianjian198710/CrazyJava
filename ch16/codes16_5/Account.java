package codes16_5;

public class Account {
	
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
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
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
}
