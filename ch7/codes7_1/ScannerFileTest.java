package codes7_1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerFileTest {

	public static void main(String[] args) throws IOException {
		/*	相对路径VS绝对路径
		 * 相对路径的当前目录指的是项目开始的目录 也就是CreazyJava目录
		 * 使用"/"开头就得是绝对目录了 指的是该项目所在的盘符
		*/
		Scanner sc = new Scanner(new File("ch7/codes7_1/ScannerFileTest.java"));
		while(sc.hasNextLine()){
			System.out.println(sc.nextLine());
		}
	}
}
