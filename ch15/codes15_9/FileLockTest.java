package codes15_9;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {
	/**
	 * 測試文件鎖
	 * FileChannel中提供lock()/tryLock()來獲取文件鎖對象(排它鎖),前者是阻塞式的,後者如得不到直接返回null
	 * 可以對文件部份內容鎖定,使用lock/tryLock(long position,long size,boolean shared)
	 * Shared為true表明是共享鎖,其他進程可以來讀取該文件,false為排它鎖,鎖住對該文件的讀寫
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
