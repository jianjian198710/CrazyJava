package codes15_9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelTest {
	/**
	 * Channel可以直接将指定文件的部分或全部直接映射成Buffer
	 * 程序不能直接访问Channel中的数据,只能与Buffer进行交互
	 * Java为Channel接口提供了DatagramChannel,FileChannel,Pipe.SinkChannel等实现类
	 * 所有的Channel都不应该通过构造器来直接创建,而是通过输入/输出流的getChannel()方法返回
	 */
	public static void main(String[] args) {
		File file = new File("ch15/codes15_9/FileChannelTest.java");
		//以文件流创建FileChannel
		try(FileChannel inChannel = new FileInputStream(file).getChannel();
			FileChannel outChannel = new FileOutputStream("a.txt").getChannel()){
				//将FileChannel里的全部数据映射成ByteBuffer,READ_ONLY指buffer不能put()只能get()
				ByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
				//使用GBK字符集来创建解码器
				Charset charset = Charset.forName("GBK");
				outChannel.write(buffer);
				//复原position,limit的位置
				buffer.clear();
				//创建解码器
				CharsetDecoder decoder = charset.newDecoder();
				//使用解码器将ByteBuffer转换成CharBuffer
				CharBuffer charBuffer = decoder.decode(buffer);
				System.out.println(charBuffer);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}

	}

}
