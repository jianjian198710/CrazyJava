package codes16_2;

public class SecondThread implements Runnable{
	/*
	 * 採用Runnable接口的方式創建的多個線程可以共享線程類的實例屬性private int i;
	 * Runnable對象僅僅作為Thread對象的Target,而實際的線程對象依然是Thread實例,
	 * 只是該Thread線程負責執行其Target的run()方法
	 */
	private int i;
	@Override
	public void run() {
		for(i=0;i<100;i++){
			//通過實現Runnable接口來獲得當前線程對象,必須使用Thread.currentThread()方法
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	public static void main(String[] args) {
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==20){
				SecondThread st = new SecondThread();
				//兩個線程共享private int i變量
				new Thread(st,"新線程1").start();
				new Thread(st,"新線程2").start();
			}
		}
	}



}
