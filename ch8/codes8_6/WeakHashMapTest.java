package codes8_6;

import java.util.WeakHashMap;

public class WeakHashMapTest {

	/**
	 * 測試WeakHashMapTest類,WeakHashMap的Key只保留了對實際對象的弱引用
	 */
	public static void main(String[] args) {
		WeakHashMap<String,String> whm = new WeakHashMap<String,String>();
		whm.put(new String("語文"),new String("良好"));
		whm.put(new String("數學"),new String("優秀"));
		whm.put(new String("英語"),new String("一般"));
		System.out.println("執行GC前whm:"+whm);
		//直接使用String為強指針,下面無法回收
		whm.put("Java", "牛逼");
		Runtime.getRuntime().gc();
		Runtime.getRuntime().runFinalization();
		System.out.println("執行GC后whm:"+whm);
	}
}
