package codes7_2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
/*
 * System�����ǰJava���������ƽ̨
 */
public class SystemTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Map<String,String> env = System.getenv();
		//�@ȡ��ǰϵ�yȫ���ĭh��׃��
		for(Map.Entry<String, String> entry : env.entrySet()){
			System.out.println(entry.getKey()+" -----> "+entry.getValue());
		}
		System.out.println(System.getenv("JAVA_HOME"));
		//�@ȡ��ǰϵ�y��ȫ������
		Properties props = System.getProperties();
		//"System Properties"��ԓ�ļ��ĵ�һ��#System Properties
		props.store(new FileOutputStream("ch7/SystemProps.txt"), "System Properties");
		System.out.println("Os name is: "+System.getProperty("os.name"));
		//�@ȡϵ�y��ǰ�r�g,�@�ɂ������ķ���ֵ�ľ���ȡ�Q춵׌Ӳ���ϵ�y
		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
	}

}
