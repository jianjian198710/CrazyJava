package codes16_6;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest2 {
	/*
	 * 本程序的BlockingQueue集合容量為1,因此3個生產者線程無法連續放入元素,
	 * 必須等待消費者線程取出一個元素后,3個生產者線程的其中之一才能放入一個元素
	 */
	public static void main(String[] args) {
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(1);
		new Producer(bq).start();
		new Producer(bq).start();
		new Producer(bq).start();
		new Consumer(bq).start();

	}

}

class Producer extends Thread{
	private BlockingQueue<String> bq;
	public Producer(BlockingQueue<String> bq) {
		super();
		this.bq = bq;
	}
	
	public void run(){
		String[] strArr = new String[]{"Java","Struts","Spring"};
		for(int i=0;i<9999;i++){
			System.out.println(getName()+"生產者準備生產集合元素");
			try{
				Thread.sleep(200);
				bq.put(strArr[i%3]);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println(getName()+"生產完成"+bq);
		}
	}
}

class Consumer extends Thread{
	private BlockingQueue<String> bq;
	public Consumer(BlockingQueue<String> bq) {
		super();
		this.bq = bq;
	}
	
	public void run(){
		while(true){
			System.out.println(getName()+"消費者準備消費集合元素");
			try{
				Thread.sleep(200);
				bq.take();
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println(getName()+"消費完成"+bq);
		}
	}
	
}