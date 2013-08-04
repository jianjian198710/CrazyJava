package codes15_9;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.SortedMap;

public class CharsetTest {
	/**
	 * �yԇJVM֧�ֵľ��a��ʽ
	 */
	public static void main(String[] args) {
		SortedMap<String,Charset> map = Charset.availableCharsets();
		for(Map.Entry<String, Charset> alias:map.entrySet()){
			System.out.println(alias.getKey()+"----->"+alias.getValue());
		}
	}
}
