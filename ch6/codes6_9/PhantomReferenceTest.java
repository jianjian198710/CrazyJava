package codes6_9;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest {

	public static void main(String[] args) {
		String str = new String("Hello Java!");
		ReferenceQueue<String> rq = new ReferenceQueue<String>();
		PhantomReference<String> pr = new PhantomReference<String>(str,rq);
		str = null;
		System.out.println(pr.get());
		System.gc();
		System.runFinalization();
		System.out.println(rq.poll() == pr);

	}

}
