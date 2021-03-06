package codes18_4;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ExtendedObjectPoolFactory {

	private Map<String,Object> objectPool = new HashMap<>();
	private Properties config = new Properties();
	public void init(String fileName){
		try(FileInputStream fis = new FileInputStream(fileName)){
			config.load(fis);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	private Object createObject(String clazzName) throws Exception{
		Class<?> clazz = Class.forName(clazzName);
		return clazz.newInstance();
	}
	
	public void initPool() throws Exception{
		for(String name:config.stringPropertyNames()){
			if(!name.contains("%")){
				objectPool.put(name, createObject(config.getProperty(name)));
			}
		}
	}
	
	public void initProperty() throws Exception{
		for(String name:config.stringPropertyNames()){
			if(name.contains("%")){
				String[] objAndProp = name.split("%");
				Object target = getObject(objAndProp[0]);
				//该Filed对应的setter方法名
				String mtdName = "set"+objAndProp[1].substring(0,1).toUpperCase()+objAndProp[1].substring(1);
				//获取该属性的setter方法
				Class<?> targetClass = target.getClass();
				Method mtd = targetClass.getMethod(mtdName, String.class);
				//通过Method的Invoke方法执行setter方法
				mtd.invoke(target, config.getProperty(name));
			}
		}
	}
	
	public Object getObject(String name){
		return objectPool.get(name);
	}
	public static void main(String[] args) throws Exception {
		ExtendedObjectPoolFactory epf = new ExtendedObjectPoolFactory();
		epf.init("extObj.txt");
		epf.initPool();
		epf.initProperty();
		System.out.println(epf.getObject("a"));
	}
}
