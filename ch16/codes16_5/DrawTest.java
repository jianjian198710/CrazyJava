package codes16_5;

public class DrawTest {
	
	public static void main(String[] args){
		Account account = new Account("123456",1000);
		DrawThread dt = new DrawThread(account,600.00);
		Thread t1 = new Thread(dt,"线程1");
		Thread t2 = new Thread(dt,"线程2");
		t1.start();
		t2.start();
	}
}
