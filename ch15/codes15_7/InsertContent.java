package codes15_7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertContent {
	/**
	 * �yԇ���ļ��в������,RandomAccessFile�o��ֱ�Ӳ���,
	 * �Ȍ������c��ă��݌��M���n�^,Ȼ�������Ҫ�ă���,���ጢ���n�^�ă��ݽ��ڲ�����ݵ�����
	 * 
	 */
	public static void insert(String filename,long pos,String insertContent) throws IOException{
		//�����R�r�ļ�ǰ�Y����tmp
		File tmp = File.createTempFile("tmp", null);
		tmp.deleteOnExit();
		try(RandomAccessFile raf = new RandomAccessFile(filename,"rw");
			FileOutputStream fos = new FileOutputStream(tmp);
			FileInputStream fis = new FileInputStream(tmp)){
			//�x������c
			raf.seek(pos);
			byte[] bytes = new byte[64];
			int hasRead = 0;
			//�������c��ă��݌����R�r�ļ�
			while((hasRead=raf.read(bytes))>0){
				fos.write(bytes, 0, hasRead);
			}
			raf.seek(pos);
			//�������
			raf.write(insertContent.getBytes());
			//���R�r�ļ��ļ��ă����B�ӵ�������ݵ�����
			while((hasRead=fis.read(bytes))>0){
				raf.write(bytes,0,hasRead);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		insert("out.txt", 10, "����ă�ͬ");
	}
}
