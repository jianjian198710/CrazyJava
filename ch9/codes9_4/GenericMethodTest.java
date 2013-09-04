package codes9_4;

import java.util.ArrayList;
import java.util.Collection;
/*
 * (1)所谓泛型方法,就是在声明方法时定义一个或多个类型形参
 * (2)泛型方法允许类型形参被用来表示方法的一个或多个形参之间的类型依赖关系,或者方法返回值与参数之间的类型依赖关系
 */
public class GenericMethodTest {
	//使用一个泛型方法,该泛型方法中带一个T类型形参,所有的类型形参声明放在方法修饰符和方法返回值类型之间
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
