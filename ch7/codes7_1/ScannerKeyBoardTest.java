package codes7_1;

import java.util.Scanner;
/*
 * (1)Scanner是一个基于正则表达式的文本扫描器,它可以从文件,输入流,字符串中解析出内容
 * (2)默认情况下,Scanner使用空白(包括空格,Tab空格,回车)作为多个输入项之间的分隔符
 */
public class ScannerKeyBoardTest {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		//为Scanner设置分隔符,参数是正则表达式
		sc.useDelimiter("\\s");
		while(sc.hasNext()){
			System.out.println("The input from keyboard is: "+sc.next());
		}
		sc.close();
	}

}
