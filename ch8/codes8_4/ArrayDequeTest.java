package codes8_4;

import java.util.ArrayDeque;
/**
 * (1)�yԇArrayDeque�,ԓ��F��Deque�ӿ�,��������У�Ҳ����������ʹ��
 * (2)Deque�ӿڼ̳���Queue�ӿ�,LinkedListҲʵ����Deque�ӿ�
 * (3)ArrayDeque�ĵײ㳤��Ϊ16
 */
public class ArrayDequeTest {

	public static void main(String[] args) {
		ArrayDeque<String> stack = new ArrayDeque<String>();
		stack.push("Crazy Java");
		stack.push("Crazy Ajax");
		stack.push("Fuch Erlang");
		System.out.println(stack);
		System.out.println(stack.peek());
		System.out.println(stack.poll());
		System.out.println(stack);
	}
}
