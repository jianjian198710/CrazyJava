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
	 * Channel����ֱ�ӽ�ָ���ļ��Ĳ��ֻ�ȫ��ֱ��ӳ���Buffer
	 * ������ֱ�ӷ���Channel�е�����,ֻ����Buffer���н���
	 * JavaΪChannel�ӿ��ṩ��DatagramChannel,FileChannel,Pipe.SinkChannel��ʵ����
	 * ���е�Channel����Ӧ��ͨ����������ֱ�Ӵ���,����ͨ������/�������getChannel()��������
	 */
	public static void main(String[] args) {
		File file = new File("ch15/codes15_9/FileChannelTest.java");
		//���ļ�������FileChannel
		try(FileChannel inChannel = new FileInputStream(file).getChannel();
			FileChannel outChannel = new FileOutputStream("a.txt").getChannel()){
				//��FileChannel���ȫ������ӳ���ByteBuffer,READ_ONLYָbuffer����put()ֻ��get()
				ByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
				//ʹ��GBK�ַ���������������
				Charset charset = Charset.forName("GBK");
				outChannel.write(buffer);
				//��ԭposition,limit��λ��
				buffer.clear();
				//����������
				CharsetDecoder decoder = charset.newDecoder();
				//ʹ�ý�������ByteBufferת����CharBuffer
				CharBuffer charBuffer = decoder.decode(buffer);
				System.out.println(charBuffer);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}

	}

}
