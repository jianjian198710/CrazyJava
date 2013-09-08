package codes10_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class AutoCloseTest {
	/**
	 * (1)try(),括號內可以聲明,初始化一個或者多個資源,try語句在該語句結束時自動關閉這些資源
	 * (2)爲了保證自動關閉這些資源,這些資源必須實現AutoCloseable或者Closeable接口,一般的BufferedReader等都實現了該類
	 * (3)AutoCloseable是Closeable的子藉口,Closeable接口里的close()方法聲明拋出了IOException,因此實現類在實現close()方法只能拋出IOException方法,
	 * 	    而AutoCloseable接口里的close()方法聲明跑出了Exception,因此實現類實現該方法時可以拋出任何異常
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
