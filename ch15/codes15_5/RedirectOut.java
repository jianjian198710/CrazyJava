package codes15_5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class RedirectOut {
	/**
	 * �yԇ��׃�˜�ݔ��/ݔ����,Ĭ�J���I�P/��Ļ
	 * System��ṩ3���ض���˜�ݔ��/ݔ���ķ���
	 * (1)static void setErr(PrintStream err)
	 * (2)static void setIn(InputStream in)
	 * (3)static void setOut(PrintStream out)
	 */
	public static void main(String[] args) {
		try(PrintStream ps = new PrintStream(new FileOutputStream("out.txt"))){
			System.setOut(ps);
			System.out.println("AAA!!!");
			System.out.println(new RedirectOut());
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

}
