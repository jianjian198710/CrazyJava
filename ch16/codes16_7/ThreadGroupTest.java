package codes16_7;
/*
 * (1)Java使用ThreadGroup來表示線程組,用戶創建的所有線程都屬於指定線程組,如果程序沒有顯示指定線程屬於哪個線程,則該線程屬於默認線程組
 * (2)默認情況下,子線程和創件它的線程處於同一個線程組內
 * (3)線程運行中不能改變它的線程組
 * Thread類提供了如下幾個構造器來設置新建的線程屬於哪個線程組
 *     (a)Thread(ThreadGroup group,Runnable target)
 *     (b)Thread(ThreadGroup group,Runnable target,String name)
 *     (c)Thread(ThreadGroup group,String name)
 * ThreadGroup提供如下簡單方法來創建實例
 *     (a)ThreadGroup(String name)
 *     (b)ThreadGroup(ThreadGroup parent,String name)
 * ThreadGroup提供如下幾個常用的方法來操作整個線程組里的所有線程
 * 	    int activeCount()返回線程組中活動線程的數目
 * 	    interrupt()終端線程組中的所有線程
 *      isDeamon()判斷該線程組是否為後臺線程
 *      setDaemon(boolean daemon)
 *      setMaxPriority(int pri)
 */
public class ThreadGroupTest {
	
	
	public static void main(String[] args) {
		//獲取主線程所在的線程組,這是所有線程默認的線程組
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		System.out.println("主線程組的名字: "+mainGroup.getName());
		System.out.println("主線程組是否為後臺線程組: "+mainGroup.isDaemon());
		new Thread("主線程組的線程").start();
		//創建線程組tg
		ThreadGroup tg = new ThreadGroup("新線程組");
		tg.setDaemon(true);
		System.out.println("tg線程組是否是後臺線程組: "+tg.isDaemon());
		//在線程組tg中創建新線程
		MyThread tt = new MyThread(tg,"tg組的線程甲");
		tt.start();
		new MyThread(tg,"tg組的線程乙");
	}

}

class MyThread extends Thread{
	public MyThread(String name){
		super(name);
	}
	public MyThread(ThreadGroup group,String name){
		super(group,name);
	}
	public void run(){
		for(int i=0;i<20;i++){
			System.out.println(getName()+" 線程的i變量"+i);
		}
	}
}