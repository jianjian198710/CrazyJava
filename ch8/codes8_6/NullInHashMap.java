package codes8_6;

import java.util.HashMap;

public class NullInHashMap {

	/**
	 * HashMap����ʹ��null����key��value
	 */
	public static void main(String[] args) {
		HashMap<String, String> m = new HashMap<String, String>();
		m.put(null, null);
		m.put("a",null);
		System.out.println(m);
	}

}
