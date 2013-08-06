package codes16_4;
/*
 * (1)yield()是一個靜態方法,可以讓當前的線程暫停,但不會阻塞該線程,只是讓線程進入就緒狀態.
 * (2)yield()只是讓當前線程暫停一下,并讓系統的線程調度器重新調度一次.
 * (3)有可能某個線程執行yield()以後,系統又將其調出來重新執行.
 * (4)當某個線程調用yield()之後,只有優先級與當前線程相同或者更高的處於就緒狀態的線程才有貨的執行的機會
 */
public class YieldTest extends Thread{

	public YieldTest(String name){
		super(name);
	}
	
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(getName()+" "+i);
			if(i==20){
				Thread.yield();
			}
		}
	}
	
	public static void main(String[] args) {
		YieldTest yt1 = new YieldTest("高級");
		//yt1.setPriority(MAX_PRIORITY);
		yt1.start();
		YieldTest yt2 = new YieldTest("低級");
		//yt2.setPriority(MIN_PRIORITY);
		yt2.start();
	}

}
