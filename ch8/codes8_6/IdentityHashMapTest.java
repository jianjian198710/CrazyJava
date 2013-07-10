package codes8_6;

import java.util.IdentityHashMap;

public class IdentityHashMapTest {
	/**
	 * 測試IdentityHashMap類,IdentityHashMap判斷兩個key的相等準則是key1==key2
	 */
	public static void main(String[] args) {
		IdentityHashMap<String,Integer> ihm = new IdentityHashMap<String,Integer>();
		ihm.put(new String("語文"), 89);
		ihm.put(new String("數學"), 78);
		ihm.put("Java", 93);
		ihm.put("Java", 98);
		System.out.println(ihm);
	}
}
