package codes8_6;

import java.util.IdentityHashMap;

public class IdentityHashMapTest {
	/**
	 * �yԇIdentityHashMap�,IdentityHashMap�Д��ɂ�key����Ȝʄt��key1==key2
	 */
	public static void main(String[] args) {
		IdentityHashMap<String,Integer> ihm = new IdentityHashMap<String,Integer>();
		ihm.put(new String("�Z��"), 89);
		ihm.put(new String("���W"), 78);
		ihm.put("Java", 93);
		ihm.put("Java", 98);
		System.out.println(ihm);
	}
}
