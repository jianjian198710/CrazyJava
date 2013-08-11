package codes16_6;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
	/**
	 * �yԇBlockingQueue�ӿ�
	 * (1)BlockingQueue��Queue���ӽӿ�,�����a�߾���ԇ�D��BlockingQueue�з���Ԫ�ؕr,���ԓ����ѝM,�tԓ���̱�����;
	 *    �����M�߾���ԇ�D��BlockingQueue��ȡ��Ԫ�ؕr,���ԓ����ѿ�,�tԓ���̱�����
	 * (2)BlockingQueue�ṩ�ɂ�֧�������ķ���
	 * 	  (a)put(E e)
	 *    (b)take()���^��ȡ��Ԫ��,�����е�Ԫ���ѿ�,�t����ԓ����
	 * (3)ʹ��Queue�ӿ��еķ���
	 * 	  (a)�����β������Ԫ��:add(E e),offer(E e),put(E e),������ѝM�r,�@���������քe��������,false,�������
	 *    (b)������^���h�������؄h����Ԫ�� remove(),poll(),take()��������ѿՕr,�@���������քe����������,false���������
	 *    (c)������^��ȡ�������h��Ԫ�� element(),peek(),����О�Օr,�@�ɂ������քe�ܳ�������false
	 * (4)BlockingQueue����5�����F�,ArrayBlockingQueue,LinkedBlockingQueue,PriorityBlockingQueue,SynchronousQueue��DelayQueue
	 */
	public static void main(String[] args){
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(2);
		try{
			bq.put("Java");
			bq.put("Java");
			//����ѝM,����
			bq.put("Java");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
