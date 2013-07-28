package codes15_5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class RedirectOut {
	/**
	 * 測試改變標準輸入/輸出流,默認為鍵盤/屏幕
	 * System類提供3個重定向標準輸入/輸出的方法
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
