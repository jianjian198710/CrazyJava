package codes10_2;

import java.io.FileInputStream;
import java.io.IOException;

public class AccessException {
	/**
	 * �yԇ��������Ďׂ�����getMessage(),printStackTrace(),printStackTrace(PrintStream s),getStackTrace()
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
