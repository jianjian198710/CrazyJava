package codes18_1;
/*
 * 当使用ClassLoader类的loadClass()方法来加载某个类时,该方法只是加载类,并不会执行该类的初始化;
 * 使用Class的forName()静态方法擦开会导致强制初始化该类
 */
public class ClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		//仅仅加载,没有初始化
		cl.loadClass("codes18_1.Tester");
		System.out.println("系统加载初始化类");
		//强制初始化Tester类
		Class.forName("codes18_1.Tester");
	}
}

class Tester{
	static{
		System.out.println("Tester类的静态初始化块...");
	}
}