package codes15_7;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	/**
	 * ����RandomAccessFileTest��,RandomAccessFile���������һ����¼ָ��,���ڱ�ʶ��ǰ��д����λ��,
	 * �����������������������ļ���¼ָ��
	 * (1)long getFilePointer() �����ļ���¼ָ��ĵ�ǰλ��
	 * (2)void seek(long pos) ���ļ���¼ָ�붨λ��posλ��
	 * RandomAccessFile��������������
	 * ����InputStream/Reader,OutputStream/Wirter�ĸ���read��write����
	 */
	public static void main(String[] args) {
		try(RandomAccessFile raf = new RandomAccessFile("ch15/codes15_7/RandomAccessFileTest.java","r")){
			System.out.println("RandomAccessFile���ļ�ָ��ĳ�ʼλ��:"+raf.getFilePointer());
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
