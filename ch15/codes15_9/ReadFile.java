package codes15_9;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ReadFile {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("ch15/codes15_9/ReadFile.java");
			FileChannel inChannel = fis.getChannel()){
				ByteBuffer buffer = ByteBuffer.allocate(64);
				while((inChannel.read(buffer))!=-1){
					buffer.flip();
					Charset charset = Charset.forName("GBK");
					CharsetDecoder decoder = charset.newDecoder();
					CharBuffer charBuffer = decoder.decode(buffer);
					System.out.println(charBuffer);
					buffer.clear();
				}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

}
