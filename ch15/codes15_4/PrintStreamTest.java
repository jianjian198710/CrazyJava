package codes15_4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {
	/**
	 *�yԇ̎����PrintStream
	 *PrintStream����ʮ�֏���,��Ҫݔ���ı�����,����ԓ��ݔ�������b��PrintStream
	 */
	public static void main(String[] args) {
		try(FileOutputStream fos = new FileOutputStream("test.txt");
			PrintStream ps = new PrintStream(fos)){
			ps.println("��ͨ�ַ���");
			ps.println(new PrintStreamTest());
		}catch(IOException ioe){
			ioe.printStackTrace();
		}

	}

}
