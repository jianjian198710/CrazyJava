package codes8_6;

import java.util.WeakHashMap;

public class WeakHashMapTest {

	/**
	 * �yԇWeakHashMapTest�,WeakHashMap��Keyֻ�����ˌ����H�����������
	 */
	public static void main(String[] args) {
		WeakHashMap<String,String> whm = new WeakHashMap<String,String>();
		whm.put(new String("�Z��"),new String("����"));
		whm.put(new String("���W"),new String("����"));
		whm.put(new String("Ӣ�Z"),new String("һ��"));
		System.out.println("����GCǰwhm:"+whm);
		//ֱ��ʹ��String�鏊ָ�,����o������
		whm.put("Java", "ţ��");
		Runtime.getRuntime().gc();
		Runtime.getRuntime().runFinalization();
		System.out.println("����GC��whm:"+whm);
	}
}
