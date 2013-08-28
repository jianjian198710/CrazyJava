package codes18_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/*
 * 通过反射生成对象有如下两种方式:
 * (1)使用Class对象的newInstance(),该方法要求该Class对象的对应类有默认构造器
 * (2)先使用Class对象获取指定的Constructor对象,再调用Constructor对象的newInstance()来创建,
 * 	    通过这种方式可以选择使用指定的构造器
 */
public class ObjectPoolFactory {
	//定义一个对象池,前面是对象名,后面是实际对象
	private Map<String,Object> objectPool = new HashMap<>();
	private Object createObject(String clazzName) throws Exception{
		Class<?> clazz = Class.forName(clazzName);
		return clazz.newInstance();
	}
	
	public void initPool(String filename) throws Exception{
		try(FileInputStream fis = new FileInputStream(filename)){
			Properties props = new Properties();
			props.load(fis);
			for(String name: props.stringPropertyNames()){
				objectPool.put(name, createObject(props.getProperty(name)));
			}
		}catch(IOException ioe){
			System.out.println("读取"+filename+" 异常");
		}
	}
	
	public Object getObject(String name){
		return objectPool.get(name);
	}
	
	public static void main(String[] args) throws Exception {
		ObjectPoolFactory pf = new ObjectPoolFactory();
		pf.initPool("obj.txt");
		System.out.println(pf.getObject("a"));
		System.out.println(pf.getObject("b"));
	}

}
