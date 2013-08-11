package codes16_6;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
	/**
	 * 測試BlockingQueue接口
	 * (1)BlockingQueue是Queue的子接口,當生產者線程試圖向BlockingQueue中放入元素時,如果該隊列已滿,則該線程被阻塞;
	 *    當消費者線程試圖從BlockingQueue中取出元素時,如果該隊列已空,則該線程被阻塞
	 * (2)BlockingQueue提供兩個支持阻塞的方法
	 * 	  (a)put(E e)
	 *    (b)take()從頭部取出元素,如果隊列的元素已空,則阻塞該線程
	 * (3)使用Queue接口中的方法
	 * 	  (a)在隊列尾部插入元素:add(E e),offer(E e),put(E e),當隊列已滿時,這三個方法分別拋出異常,false,阻塞隊列
	 *    (b)在隊列頭部刪除并返回刪除的元素 remove(),poll(),take()，當隊列已空時,這三個方法分別會拋出異常,false，阻塞隊列
	 *    (c)在隊列頭部取出但不刪除元素 element(),peek(),當隊列為空時,這兩個方法分別跑出異常和false
	 * (4)BlockingQueue包含5個實現類,ArrayBlockingQueue,LinkedBlockingQueue,PriorityBlockingQueue,SynchronousQueue和DelayQueue
	 */
	public static void main(String[] args){
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(2);
		try{
			bq.put("Java");
			bq.put("Java");
			//隊列已滿,阻塞
			bq.put("Java");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
