package codes6_9;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
/*
 * 虛引用主要用於跟蹤對象GC的狀態,它不能單獨使用,必須和引用隊列ReferenceQueue聯合使用
 */
public class PhantomReferenceTest {

	public static void main(String[] args) {
		String str = new String("Hello Java!");
		ReferenceQueue<String> rq = new ReferenceQueue<String>();
		//創建一個虛引用,指向Hello Java!
		PhantomReference<String> pr = new PhantomReference<String>(str,rq);
		str = null;
		//不能通過虛引用訪問被引用對象,所以此處為null
		System.out.println(pr.get());
		System.gc();
		System.runFinalization();
		//當被引用的對象回收后,虛引用將被放入引用隊列中
		System.out.println(rq.poll() == pr);

	}

}
