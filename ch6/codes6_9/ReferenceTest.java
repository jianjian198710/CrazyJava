package codes6_9;

import java.lang.ref.WeakReference;

public class ReferenceTest {

	public static void main(String[] args) {
		
		String str = new String("Hello Java!");
//		String str = "Hello Java!"; 
		WeakReference<String> wf = new WeakReference<String>(str);
		str = null;
		System.out.println(wf.get());
		System.gc();
		System.out.println(wf.get());
	}

}
