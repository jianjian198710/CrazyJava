package codes15_7;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	/**
	 * 测试RandomAccessFileTest类,RandomAccessFile对象包含了一个记录指针,用于标识当前读写处的位置,
	 * 包含如下两个方法来操作文件记录指针
	 * (1)long getFilePointer() 返回文件记录指针的当前位置
	 * (2)void seek(long pos) 将文件记录指针定位到pos位置
	 * RandomAccessFile类有两个构造器
	 * 包含InputStream/Reader,OutputStream/Wirter的各种read和write方法
	 */
	public static void main(String[] args) {
		try(RandomAccessFile raf = new RandomAccessFile("ch15/codes15_7/RandomAccessFileTest.java","r")){
			System.out.println("RandomAccessFile的文件指针的初始位置:"+raf.getFilePointer());
			raf.seek(300);
			byte[] bytes = new byte[1024];
			int hasRead = 0;
			while((hasRead=raf.read(bytes))>0){
				System.out.println(new String(bytes,0,hasRead));
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

}
