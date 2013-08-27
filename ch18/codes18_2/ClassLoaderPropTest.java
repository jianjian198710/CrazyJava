package codes18_2;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
/*
 * JVM����ػ�����Ҫ��3��
 * (1)ȫ�̸���
 * (2)����ί��
 * (3)�������
 */
public class ClassLoaderPropTest {
	
	public static void main(String[] args) throws IOException{
		ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
		System.out.println("ϵͳ�������: "+systemLoader);
		/*
		 * ��ȡϵͳ��������ļ���·����������ͨ����CLASSPATH��������ָ��
		 * �������ϵͳû��ָ��CLASSPATH��������,��Ĭ���Ե�ǰ·��Enumeration<E>·��
		 */
		Enumeration<URL> eml = systemLoader.getResources("");
		while(eml.hasMoreElements()){
			System.out.println(eml.nextElement());
		}
		//��ȡϵͳ��������ĸ��������,�õ���չ�������
		ClassLoader extensionLoader = systemLoader.getParent();
		System.out.println("��չ�������: "+extensionLoader);
		System.out.println("��չ��������ļ���·��: "+System.getProperty("java.ext.dirs"));
		//���null����Ϊ�����������û�м̳�ClassLoader������,���������������Javaʵ�ֵ�
		System.out.println("��չ���������parent: "+extensionLoader.getParent());
	}
	
}
