package codes6_9;

import java.lang.ref.WeakReference;
/*
 * 引用分為四種:強,軟,弱,虛
 */
public class ReferenceTest {

	public static void main(String[] args) {
		
		String str = new String("Hello Java!");
		//採用String str="Hello Java!",系統會使用常量池來管理該String,是強引用
//		String str = "Hello Java!"; 
		WeakReference<String> wf = new WeakReference<String>(str);
		str = null;
		System.out.println(wf.get());
		System.gc();
		System.out.println(wf.get());
	}

}
