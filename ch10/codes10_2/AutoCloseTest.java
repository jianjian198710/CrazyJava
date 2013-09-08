package codes10_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class AutoCloseTest {
	/**
	 * (1)try(),��̖�ȿ�����,��ʼ��һ�����߶����YԴ,try�Z����ԓ�Z��Y���r�Ԅ��P�]�@Щ�YԴ
	 * (2)���˱��C�Ԅ��P�]�@Щ�YԴ,�@Щ�YԴ��회��FAutoCloseable����Closeable�ӿ�,һ���BufferedReader�ȶ����F��ԓ�
	 * (3)AutoCloseable��Closeable���ӽ��,Closeable�ӿ����close()������������IOException,��ˌ��F��ڌ��Fclose()����ֻ�ܒ���IOException����,
	 * 	    ��AutoCloseable�ӿ����close()�������ܳ���Exception,��ˌ��F��Fԓ�����r���Ԓ����κή���
	 * 	  Closeable @throws IOException 
	 *    AutoCloseable @throws FileNotFoundException 
	 */
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new FileReader("ch10/codes10_2/AutoCloseTest.java"));
			PrintStream ps = new PrintStream(new FileOutputStream("a.txt")))	
			{
				while(br.readLine()!=null){
					System.out.println(br.readLine());
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
