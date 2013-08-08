package codes16_5;

public class SynchronizedAccountTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SynchronizedAccount account = new SynchronizedAccount("12345", 0);
		SynchronizedAccountDrawThread draw = new SynchronizedAccountDrawThread(account, 800);
		SynchronizedAccountDepositThread deposit = new SynchronizedAccountDepositThread(account, 800);
		Thread t1 = new Thread(draw,"取款者");
		Thread t2 = new Thread(deposit,"存款者甲");
		Thread t3 = new Thread(deposit,"存款者乙");
		Thread t4 = new Thread(deposit,"存款者丙");
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
