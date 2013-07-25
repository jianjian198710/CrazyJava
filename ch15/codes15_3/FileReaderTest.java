package codes15_3;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
	/**
	 * ͬFileInputStreamTest.java
	 */
	public static void main(String[] args) {
		try(FileReader fr = new FileReader("ch15/codes15_3/FileReaderTest.java")){
			char[] chs = new char[32];
			int hasRead = 0;
			while((hasRead = fr.read(chs))>0){
				System.out.println(new String(chs,0,hasRead));
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
