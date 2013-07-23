package codes14_3;

import java.lang.reflect.Method;

/**
 * ÌŽÀí˜ËÓ›
 */
public class ProcessorTest {
	
	public static void process(String clazz) throws ClassNotFoundException{
		int passed = 0;
		int failed = 0;
//		MyTest myTest = new MyTest();
		for(Method m:Class.forName(clazz).getMethods()){
			if(m.isAnnotationPresent(Testable.class)){
				try{
					m.invoke(null);
					passed++;
				}catch(Exception ex){
					System.out.println("Method: "+m+" Failed!"+ex.getCause());
					failed++;
				}
			}
		}
		System.out.println("Run "+(passed+failed)+" methods");
	}
} 
