package codes7_1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerFileTest {

	public static void main(String[] args) throws IOException {
		/*	���·��VS����·��
		 * ���·���ĵ�ǰĿ¼ָ������Ŀ��ʼ��Ŀ¼ Ҳ����CreazyJavaĿ¼
		 * ʹ��"/"��ͷ�͵��Ǿ���Ŀ¼�� ָ���Ǹ���Ŀ���ڵ��̷�
		*/
		Scanner sc = new Scanner(new File("ch7/codes7_1/ScannerFileTest.java"));
		while(sc.hasNextLine()){
			System.out.println(sc.nextLine());
		}
	}
}
