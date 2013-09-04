package codes8_4;

import java.util.PriorityQueue;
/**
 * (1)PriorityQueue保存队列元素的顺序并不是按加入队列的顺序,而是按队列元素的大小进行排序的
 * (2)PriorityQueue队列对元素的要求基本与TreeSet对元素的要求基本一致
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
