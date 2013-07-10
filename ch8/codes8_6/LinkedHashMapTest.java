package codes8_6;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
	/**
	 *œyÔ‡LinkedHashMap
	 */
	public static void main(String[] args) {
		LinkedHashMap<String,Integer> scores = new LinkedHashMap<String,Integer>();
		scores.put("ÕZÎÄ", 80);
		scores.put("”µŒW", 86);
		scores.put("Ó¢ÕZ", 76);
		for(Map.Entry<String,Integer> entry :scores.entrySet()){
			System.out.print(entry.getKey()+"----->");
			System.out.println(entry.getValue());
		}
	}
}
