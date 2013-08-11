package codes16_6;

public class SynchronizedAccountTest {

	public static void main(String[] args) {
		SynchronizedAccount account = new SynchronizedAccount("12345", 0);
		SynchronizedAccountDrawThread draw = new SynchronizedAccountDrawThread(account, 800);
		SynchronizedAccountDepositThread deposit = new SynchronizedAccountDepositThread(account, 800);
		Thread t1 = new Thread(draw,"取款者");
		Thread t2 = new Thread(deposit,"存款者甲");
		Thread t3 = new Thread(deposit,"存款者乙");
		Thread t4 = new Thread(deposit,"存款者丙");
		/*
		 * (1)輸出結果不等於循環的次數,因為有些線程執行了wait()方法后阻塞,也算執行了一次尋緣
		 * (2)程序運行后阻塞,并不是死鎖,取錢者先撤全部執行結束,只有100次,存錢者只是在等待其他線程來取錢,因為有3*100次存錢操作
		 */
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
