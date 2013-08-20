package codes18_1;
/*
 * ��ʹ��ClassLoader���loadClass()����������ĳ����ʱ,�÷���ֻ�Ǽ�����,������ִ�и���ĳ�ʼ��;
 * ʹ��Class��forName()��̬���������ᵼ��ǿ�Ƴ�ʼ������
 */
public class ClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		//��������,û�г�ʼ��
		cl.loadClass("codes18_1.Tester");
		System.out.println("ϵͳ���س�ʼ����");
		//ǿ�Ƴ�ʼ��Tester��
		Class.forName("codes18_1.Tester");
	}
}

class Tester{
	static{
		System.out.println("Tester��ľ�̬��ʼ����...");
	}
}