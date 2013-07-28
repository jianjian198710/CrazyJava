package codes15_7;

import java.io.IOException;
import java.io.RandomAccessFile;

public class AppendContent {
	/**
	 * 測試追加內容
	 */
	public static void main(String[] args) {
		try(RandomAccessFile raf = new RandomAccessFile("out.txt","rw")){
			//指針指向文件的結尾
			raf.seek(raf.length());
			raf.write("追加的內容!\r\n".getBytes());
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

}
