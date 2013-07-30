package codes15_9;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class RandomFileChannelTest {
	/**
	 * RandomAccessFileҲ������getChannel()����,���ص�FileChannel()��ֻ���Ļ��Ƕ�д��Channel,
	 * ȡ����RandomAccessFile���ļ���ģʽ
	 */
	public static void main(String[] args) {
		File file = new File("a.txt");
		try(RandomAccessFile raf = new RandomAccessFile(file,"rw");
			FileChannel fc = raf.getChannel()){
				ByteBuffer buffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
				//��positionλ���Ƶ����
				fc.position(file.length());
				fc.write(buffer);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
	}

}
