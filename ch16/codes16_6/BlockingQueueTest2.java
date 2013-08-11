package codes16_6;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest2 {
	/*
	 * �������BlockingQueue����������1,���3�����a�߾��̟o���B�m����Ԫ��,
	 * ��횵ȴ����M�߾���ȡ��һ��Ԫ�غ�,3�����a�߾��̵�����֮һ���ܷ���һ��Ԫ��
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
			System.out.println(getName()+"���a�ߜʂ����a����Ԫ��");
			try{
				Thread.sleep(200);
				bq.put(strArr[i%3]);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println(getName()+"���a���"+bq);
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
			System.out.println(getName()+"���M�ߜʂ����M����Ԫ��");
			try{
				Thread.sleep(200);
				bq.take();
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println(getName()+"���M���"+bq);
		}
	}
	
}