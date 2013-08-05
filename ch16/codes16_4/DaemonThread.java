package codes16_4;
/*
 * 如果所有的前台線程都死亡,後臺線程會自動死亡
 */
public class DaemonThread extends Thread{

	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(this.getName()+" "+i);
		}
	}
	public static void main(String[] args) {
		DaemonThread dt = new DaemonThread();
		//setDaemon(ture)必須在start()之前調用,否則會引發IllegalThreadStateException
		dt.setDaemon(true);
		dt.start();
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
		//此處mian線程結束了,後臺線程也自動結束了
	}

}
