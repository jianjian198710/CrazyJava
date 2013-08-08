package codes16_5;

public class LockAccountDrawTest {

	public static void main(String[] args) {
		LockAccount lockAccount = new LockAccount("12345",1000.00);
		Thread t1 = new Thread(new LockAccountDrawThread(lockAccount,600),"线程1");
		Thread t2 = new Thread(new LockAccountDrawThread(lockAccount,600),"线程2");
		t1.start();
		t2.start();
	}

}
