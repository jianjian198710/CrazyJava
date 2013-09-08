package codes15_1;

import java.io.File;
import java.io.IOException;

public class FileTest {
	/**
	 * �������ļ�����Ŀ¼����ʹ��File��������
	 */
	public static void main(String[] args) throws IOException {
		//fileָ������·����ǰĿ�,����Ŀ�..
		File file = new File(".");
		//�˳�JVM�r�Ԅӄh��ԓ�ļ�
		file.deleteOnExit();
		//�@ȡ�ļ���
		System.out.println(file.getName());
		//�@ȡ����·���ĸ�·��
		System.out.println(file.getParent());
		//�@ȡ�^��·��
		System.out.println(file.getAbsolutePath());
		//�@ȡ��һ��·��
		System.out.println(file.getAbsoluteFile().getParent());
		
		File newFile = new File(System.currentTimeMillis()+"");
		System.out.println("newFile�Ƿ����:"+newFile.exists());
		System.out.println(newFile.createNewFile());
		newFile.deleteOnExit();
		
		System.out.println(file.mkdir());
		//list()�����г���ǰ·���������ļ���·��
		for(String fileName:file.list()){
			System.out.println(fileName);
		}
		System.out.println("=======ϵ�y���и�·������========");
		//listRoots()�o�B�����г����дűP��·��
		for(File root:File.listRoots()){
			System.out.println(root);
		}
		
	}

}
