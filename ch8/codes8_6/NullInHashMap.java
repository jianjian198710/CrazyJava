package codes8_6;

import java.util.HashMap;

public class NullInHashMap {

	/**
	 * (1)HashMap����ʹ��null����key��value
	 * (2)Hashtable�򲻿���ʹ��null
	 * (3)HashMap��Hashtable�ж�����Key��ȵı�׼��:����key��equals()��hashCodeֵ���
	 * (4)�ж�value��ȵı�׼��:ֻҪ����valueͨ��equals()��������true����
	 */
	public static void main(String[] args) {
		HashMap<String, String> m = new HashMap<String, String>();
		m.put(null, null);
		m.put("a",null);
		System.out.println(m);
	}

}
