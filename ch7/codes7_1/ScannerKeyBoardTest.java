package codes7_1;

import java.util.Scanner;
/*
 * (1)Scanner��һ������������ʽ���ı�ɨ����,�����Դ��ļ�,������,�ַ����н���������
 * (2)Ĭ�������,Scannerʹ�ÿհ�(�����ո�,Tab�ո�,�س�)��Ϊ���������֮��ķָ���
 */
public class ScannerKeyBoardTest {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		//ΪScanner���÷ָ���,������������ʽ
		sc.useDelimiter("\\s");
		while(sc.hasNext()){
			System.out.println("The input from keyboard is: "+sc.next());
		}
		sc.close();
	}

}
