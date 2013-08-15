package codes16_9;
/*
 * (1)ThreadLocal類代表一個線程的局部變量,通過把數據放在ThraedLocal中就可以讓每個線程創建一個該變量的副本
 * (2)ThreadLocal提供如下3個public方法
 *     (a)T get():返回此線程局部變量中當前線程的值
 * 	   (b)void remove():刪除此線程局部變量中當前線程的值
 *     (c)void set(T value):設置次線程局部變量中當前線程副本中的值
 */
public class ThreadLocalTest {

	public static void main(String[] args) {
		Account at = new Account("初始名");
		/*
		 * 雖然兩個線程共享同一個帳戶,即只有一個帳戶名,但由於帳戶名是ThreadLocal類型的,所以每個線程都完全擁有各自的帳戶名副本,
		 * 因此在i==6之後,將看到兩個線程訪問同一個帳戶時出現不同的帳戶名
		 */
		new MyTest(at,"線程甲").start();
		new MyTest(at,"線程乙").start();
	}

}

class Account{
	private ThreadLocal<String> name = new ThreadLocal<String>();
	public Account(String str){
		this.name.set(str);
		//訪問當前線程的name副本的值 (主線程為:初始名 另外兩個線程副本為:null)
		System.out.println("---"+this.name.get());
	}
	public String getName() {
		return name.get();
	}
	public void setName(String str) {
		this.name.set(str);
	}
}

class MyTest extends Thread{
	private Account account;
	public MyTest(Account account,String name){
		super(name);
		this.account = account;
	}
	@Override
	public void run(){
		for(int i=0;i<10;i++){
			if(i==6){
				//將帳戶名替換成當前線程名
				account.setName(getName());
			}
			System.out.println(account.getName()+" 帳戶i的值: "+i);	
		}
	}
}