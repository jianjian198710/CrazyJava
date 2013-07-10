package codes8_6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
	/**
	 *  �yԇProperties�
	 */
	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("username", "jianjian");
		props.setProperty("password", "198710");
		//�����ļ�
		try {
			props.store(new FileOutputStream(new File("ch8/a.ini")), "comment Line");
			props.storeToXML(new FileOutputStream("ch8/a.xml"), "comment Line");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Properties props2 = new Properties();
		//���ļ����xȡ
		try {
			props2.load(new FileInputStream(new File("ch8/a.ini")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(props2);
	}
}
