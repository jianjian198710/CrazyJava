package codes15_3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
	/**
	 * �yԇ���c��
	 * write(int c),write(byte[] b),write(byte[] b,int off,int len)���N����
	 * ��ִ��close()����֮ǰ,�Զ�ִ���������flush()����
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
