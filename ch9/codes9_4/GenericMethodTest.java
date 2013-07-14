package codes9_4;

import java.util.ArrayList;
import java.util.Collection;

public class GenericMethodTest {

	/**
	 * �yԇţ�Ƶķ��ͷ���
	 */
	static <T> void fromArrayToCollection(T[] a, Collection<T> c){
		for(T o:a){
			c.add(o);
		}
	}
	public static void main(String[] args) {
		Object[] os = new Object[100];
		Collection<Object> co = new ArrayList<Object>();
		//T����Object���
		fromArrayToCollection(os, co);
		String[] sa = new String[100];
		Collection<String> cs = new ArrayList<String>();
		//T����String���
		fromArrayToCollection(sa, cs);
		//T����Object���
		fromArrayToCollection(sa, co);
		Integer[] ia = new Integer[100];
		Float[] ta = new Float[100];
		Number[] na = new Float[100];
		Collection<Number> cn = new ArrayList<Number>();
		//T����Number���
		fromArrayToCollection(ia, cn);
		//T����Number���
		fromArrayToCollection(ta, cn);
		//T����Number���
		fromArrayToCollection(na, cn);
		//T����Object���
		fromArrayToCollection(na, co);
	}
}
