package codes15_7;

import java.io.IOException;
import java.io.RandomAccessFile;

public class AppendContent {
	/**
	 * �yԇ׷�Ӄ���
	 */
	public static void main(String[] args) {
		try(RandomAccessFile raf = new RandomAccessFile("out.txt","rw")){
			//ָ�ָ���ļ��ĽYβ
			raf.seek(raf.length());
			raf.write("׷�ӵă���!\r\n".getBytes());
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

}
