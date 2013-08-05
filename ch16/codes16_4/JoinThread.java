package codes16_4;
/*
 * 當某個程序執行流中調用其他線程的join()方法時,調用線程將被阻塞,
 * 直到被join()方法加入的join線程執行完為止
 * join()有三種重載形勢
 * (1)join()
 * (2)join(long millis):等待被join的線程的時間最長為millis毫秒
 * (3)join(long millis,int nanos)等待被join的線程的最長時間為millis毫秒加上nanos豪微秒
 */
public class JoinThread extends Thread{

	public JoinThread(String name){
		super(name);
	}
	
	@Override
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(this.getName()+" "+i);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		new JoinThread("新线程").start();
		for(int i=0;i<100;i++){
			//i=20底層精確調度jt執行
			if(i==20){
				JoinThread jt = new JoinThread("被Join的线程");
				jt.start();
				jt.join();
			}
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}

}
