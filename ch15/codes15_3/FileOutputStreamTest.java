package codes15_3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
	/**
	 * 測試節點流
	 * write(int c),write(byte[] b),write(byte[] b,int off,int len)三種方法
	 * 在执行close()方法之前,自动执行输出流的flush()方法
	 */
	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("ch15/codes15_3/FileOutputStreamTest.java");
			FileOutputStream fos = new FileOutputStream("newFile.txt")){
			byte[] b = new byte[1024];
			int hasRead = 0;
			while((hasRead = fis.read(b))>0){
				fos.write(b,0,hasRead);
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

}
