package codes8_4;

import java.util.ArrayDeque;
/**
 * (1)測試ArrayDeque類,該類實現了Deque接口,可以做隊列，也可以做棧來使用
 * (2)Deque接口继承于Queue接口,LinkedList也实现了Deque接口
 * (3)ArrayDeque的底层长度为16
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
