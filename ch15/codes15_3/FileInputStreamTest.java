package codes15_3;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
	/**
	 *�yԇ���c��
	 *read(),read(byte[] b),read(byte[] b,int off, int len)���N����
	 */
	public static void main(String[] args) throws IOException {
		try(FileInputStream fis = new FileInputStream("ch15/codes15_3/FileInputStreamTest.java")){
			byte[] b = new byte[1024];
			int hasRead = 0;
			//һ���xȡ1024���ֹ�
			while((hasRead = fis.read(b))>0){
				System.out.println(new String(b,0,hasRead));
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

}
