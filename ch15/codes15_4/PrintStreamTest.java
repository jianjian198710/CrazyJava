package codes15_4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {
	/**
	 *測試處理流PrintStream
	 *PrintStream功能十分強大,需要輸出文本內容,都應該將輸出流包裝秤PrintStream
	 */
	public static void main(String[] args) {
		try(FileOutputStream fos = new FileOutputStream("test.txt");
			PrintStream ps = new PrintStream(fos)){
			ps.println("普通字符串");
			ps.println(new PrintStreamTest());
		}catch(IOException ioe){
			ioe.printStackTrace();
		}

	}

}
