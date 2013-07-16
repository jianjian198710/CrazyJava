package codes10_2;

import java.io.FileInputStream;
import java.io.IOException;

public class AccessException {
	/**
	 * 測試異常對象的幾個方法getMessage(),printStackTrace(),printStackTrace(PrintStream s),getStackTrace()
	 */
	public static void main(String[] args) {
		try{
			FileInputStream fls = new FileInputStream("a.txt");
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}
	}

}
