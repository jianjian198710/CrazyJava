package codes8_6;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
	/**
	 *�yԇLinkedHashMap
	 */
	public static void main(String[] args) {
		LinkedHashMap<String,Integer> scores = new LinkedHashMap<String,Integer>();
		scores.put("�Z��", 80);
		scores.put("���W", 86);
		scores.put("Ӣ�Z", 76);
		for(Map.Entry<String,Integer> entry :scores.entrySet()){
			System.out.print(entry.getKey()+"----->");
			System.out.println(entry.getValue());
		}
	}
}
