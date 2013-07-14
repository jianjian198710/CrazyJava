package codes9_4;

import java.util.ArrayList;
import java.util.Collection;

public class GenericMethodTest {

	/**
	 * 測試牛逼的泛型方法
	 */
	static <T> void fromArrayToCollection(T[] a, Collection<T> c){
		for(T o:a){
			c.add(o);
		}
	}
	public static void main(String[] args) {
		Object[] os = new Object[100];
		Collection<Object> co = new ArrayList<Object>();
		//T代表Object類型
		fromArrayToCollection(os, co);
		String[] sa = new String[100];
		Collection<String> cs = new ArrayList<String>();
		//T代表String類型
		fromArrayToCollection(sa, cs);
		//T代表Object類型
		fromArrayToCollection(sa, co);
		Integer[] ia = new Integer[100];
		Float[] ta = new Float[100];
		Number[] na = new Float[100];
		Collection<Number> cn = new ArrayList<Number>();
		//T代表Number類型
		fromArrayToCollection(ia, cn);
		//T代表Number類型
		fromArrayToCollection(ta, cn);
		//T代表Number類型
		fromArrayToCollection(na, cn);
		//T代表Object類型
		fromArrayToCollection(na, co);
	}
}
