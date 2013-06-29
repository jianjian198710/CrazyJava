package codes7_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardinTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//每次readline()都要往下读一行  所以需要一个变量记住读取的当前行
		String line = null;
		while((line = br.readLine())!=null){
			System.out.println("The input from keyborad is: "+line);
		}

	}

}
