package codes15_7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertContent {
	/**
	 * 測試在文件中插入內容,RandomAccessFile無法直接插入,
	 * 先將插入點后的內容寫進緩衝區,然後插入需要的內容,最後將緩衝區的內容接在插入內容的後面
	 * 
	 */
	public static void insert(String filename,long pos,String insertContent) throws IOException{
		//創建臨時文件前綴名為tmp
		File tmp = File.createTempFile("tmp", null);
		tmp.deleteOnExit();
		try(RandomAccessFile raf = new RandomAccessFile(filename,"rw");
			FileOutputStream fos = new FileOutputStream(tmp);
			FileInputStream fis = new FileInputStream(tmp)){
			//選擇插入點
			raf.seek(pos);
			byte[] bytes = new byte[64];
			int hasRead = 0;
			//將插入點后的內容寫入臨時文件
			while((hasRead=raf.read(bytes))>0){
				fos.write(bytes, 0, hasRead);
			}
			raf.seek(pos);
			//插入內容
			raf.write(insertContent.getBytes());
			//將臨時文件文件的內容連接到插入內容的後面
			while((hasRead=fis.read(bytes))>0){
				raf.write(bytes,0,hasRead);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		insert("out.txt", 10, "插入的內同");
	}
}
