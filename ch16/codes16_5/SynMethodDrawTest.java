package codes16_5;

public class SynMethodDrawTest {
	
	public static void main(String[] args) {
		SynMethodAccount account = new SynMethodAccount("123456",1000);
		SynMethodDrawThread dt = new SynMethodDrawThread(account,600.00);
		Thread t1 = new Thread(dt,"线程1");
		Thread t2 = new Thread(dt,"线程2");
		t1.start();
		t2.start();
	}
}
