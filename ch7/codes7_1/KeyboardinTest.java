package codes7_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardinTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//ÿ��readline()��Ҫ���¶�һ��  ������Ҫһ��������ס��ȡ�ĵ�ǰ��
		String line = null;
		while((line = br.readLine())!=null){
			System.out.println("The input from keyborad is: "+line);
		}

	}

}
