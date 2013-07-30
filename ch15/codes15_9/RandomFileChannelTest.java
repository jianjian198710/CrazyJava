package codes15_9;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class RandomFileChannelTest {
	/**
	 * RandomAccessFile也包含了getChannel()方法,返回的FileChannel()是只读的还是读写的Channel,
	 * 取决于RandomAccessFile打开文件的模式
	 */
	public static void main(String[] args) {
		File file = new File("a.txt");
		try(RandomAccessFile raf = new RandomAccessFile(file,"rw");
			FileChannel fc = raf.getChannel()){
				ByteBuffer buffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
				//将position位置移到最后
				fc.position(file.length());
				fc.write(buffer);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
	}

}
