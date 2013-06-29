package codes7_2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class SystemTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Map<String,String> env = System.getenv();
		//獲取當前系統全部的環境變量
		for(Map.Entry<String, String> entry : env.entrySet()){
			System.out.println(entry.getKey()+" -----> "+entry.getValue());
		}
		System.out.println(System.getenv("JAVA_HOME"));
		//獲取當前系統的全部屬性
		Properties props = System.getProperties();
		//"System Properties"為該文件的第一行#System Properties
		props.store(new FileOutputStream("ch7/SystemProps.txt"), "System Properties");
		System.out.println("Os name is: "+System.getProperty("os.name"));
		
		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
	}

}
