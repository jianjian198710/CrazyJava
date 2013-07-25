package codes15_3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
	/**
	 *ͬFileOutputStreamTest.java
	 */
	public static void main(String[] args) {
		try(FileReader fr = new FileReader("ch15/codes15_3/FileWriterTest.java");
			FileWriter fw = new FileWriter("newFile.txt")){
			char[] chs = new char[32];
			int hasRead = 0;
			while((hasRead = fr.read(chs))>0){
				fw.write(chs, 0, hasRead);
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

}
