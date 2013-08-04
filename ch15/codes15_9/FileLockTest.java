package codes15_9;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {
	/**
	 * �yԇ�ļ��i
	 * FileChannel���ṩlock()/tryLock()��@ȡ�ļ��i����(�����i),ǰ��������ʽ��,������ò���ֱ�ӷ���null
	 * ���Ԍ��ļ����݃����i��,ʹ��lock/tryLock(long position,long size,boolean shared)
	 * Shared��true�����ǹ����i,�����M�̿��ԁ��xȡԓ�ļ�,false�������i,�iס��ԓ�ļ����x��
	 */
	public static void main(String[] args) throws InterruptedException {
		try(FileChannel channel = new FileOutputStream("a.txt").getChannel()){
				FileLock lock = channel.tryLock();
				Thread.sleep(10000);
				lock.release();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

}
