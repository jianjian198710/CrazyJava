package codes8_4;

import java.util.PriorityQueue;
/**
 * (1)PriorityQueue�������Ԫ�ص�˳�򲢲��ǰ�������е�˳��,���ǰ�����Ԫ�صĴ�С���������
 * (2)PriorityQueue���ж�Ԫ�ص�Ҫ�������TreeSet��Ԫ�ص�Ҫ�����һ��
 */
public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.offer(6);
		pq.offer(-3);
		pq.offer(9);
		pq.offer(0);
		System.out.println(pq);
		System.out.println(pq.poll());

	}

}
