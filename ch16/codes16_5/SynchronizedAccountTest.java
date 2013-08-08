package codes16_5;

public class SynchronizedAccountTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SynchronizedAccount account = new SynchronizedAccount("12345", 0);
		SynchronizedAccountDrawThread draw = new SynchronizedAccountDrawThread(account, 800);
		SynchronizedAccountDepositThread deposit = new SynchronizedAccountDepositThread(account, 800);
		Thread t1 = new Thread(draw,"ȡ����");
		Thread t2 = new Thread(deposit,"����߼�");
		Thread t3 = new Thread(deposit,"�������");
		Thread t4 = new Thread(deposit,"����߱�");
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
