package codes18_2;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
/*
 * JVM类加载机制主要有3种
 * (1)全盘负责
 * (2)父类委托
 * (3)缓存机制
 */
public class ClassLoaderPropTest {
	
	public static void main(String[] args) throws IOException{
		ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
		System.out.println("系统类加载器: "+systemLoader);
		/*
		 * 获取系统类加载器的加载路径————通常由CLASSPATH环境变量指定
		 * 如果操作系统没有指定CLASSPATH环境变量,则默认以当前路径Enumeration<E>路径
		 */
		Enumeration<URL> eml = systemLoader.getResources("");
		while(eml.hasMoreElements()){
			System.out.println(eml.nextElement());
		}
		//获取系统类加载器的父类加载器,得到扩展类加载器
		ClassLoader extensionLoader = systemLoader.getParent();
		System.out.println("扩展类加载器: "+extensionLoader);
		System.out.println("扩展类加载器的加载路径: "+System.getProperty("java.ext.dirs"));
		//输出null是因为根类加载器并没有继承ClassLoader抽象类,根类加载器并不是Java实现的
		System.out.println("扩展类加载器的parent: "+extensionLoader.getParent());
	}
	
}
