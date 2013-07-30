package codes15_9;

import java.nio.CharBuffer;

public class BufferTest {
	/**
	 * Buffer可以理解成一個容器,它可以保存多個類型相同的數據,是一個抽象類,常用為ByteBuffer和CharBuffer,
	 * 通常使用static XxxBuffer allocate(int capacity)創建一個XxxBuffer對象
	 * 在Buffer中有三個重要的概念:容量(capacity),界限(limit),位置(position)
	 * 當Buffer裝入數據結束后,調用flip()方法，將limit設置為position所在位置,并將position設為0
	 * 當Buffer輸出數據結束后,調用clear()方法,將position設為0,將limit置為capacity
	 * Buffer使用put()和get()來放入和讀取數據,分為相對和絕對兩種
	 */
	public static void main(String[] args) {
		CharBuffer buff = CharBuffer.allocate(8);
		System.out.println("capacity:"+buff.capacity());
		//初始化時limit指向8,為非實際存儲空間
		System.out.println("limit:"+buff.limit());
		System.out.println("position:"+buff.position());
		
		buff.put('a');
		buff.put('b');
		buff.put('c');
		System.out.println("放入三个元素后,position="+buff.position());
		buff.flip();
		//limit到position位置 3
		System.out.println("执行flip()后,limit="+buff.limit());
		//position移到 0
		System.out.println("position="+buff.position());
		
		System.out.println("第一个元素:"+buff.get());
		//position從第一個元素往後一格,即為1
		System.out.println("取出第一个元素后,postion="+buff.position());
		
		buff.clear();
		//limit置為capacity 8
		System.out.println("执行clear()后,limit="+buff.limit());
		//position置為 0
		System.out.println("执行clear()后,position="+buff.position());
		System.out.println("执行claer()后,缓冲区内容并没有被清除:"+buff.get(2));
		//因為前面使用get(int)方法,直接使用了索引,而沒有用到position,因此positiion位置不變 0
		System.out.println("执行读取后,position="+buff.position());
	}

}
