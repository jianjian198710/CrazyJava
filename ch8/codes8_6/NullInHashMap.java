package codes8_6;

import java.util.HashMap;

public class NullInHashMap {

	/**
	 * (1)HashMap可以使用null作為key或value
	 * (2)Hashtable则不可以使用null
	 * (3)HashMap和Hashtable判断两个Key相等的标准是:两个key的equals()和hashCode值相等
	 * (4)判断value相等的标准是:只要两个value通过equals()方法返回true即可
	 */
	public static void main(String[] args) {
		HashMap<String, String> m = new HashMap<String, String>();
		m.put(null, null);
		m.put("a",null);
		System.out.println(m);
	}

}
