package codes18_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/*
 * ͨ���������ɶ������������ַ�ʽ:
 * (1)ʹ��Class�����newInstance(),�÷���Ҫ���Class����Ķ�Ӧ����Ĭ�Ϲ�����
 * (2)��ʹ��Class�����ȡָ����Constructor����,�ٵ���Constructor�����newInstance()������,
 * 	    ͨ�����ַ�ʽ����ѡ��ʹ��ָ���Ĺ�����
 */
public class ObjectPoolFactory {
	//����һ�������,ǰ���Ƕ�����,������ʵ�ʶ���
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
			System.out.println("��ȡ"+filename+" �쳣");
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
