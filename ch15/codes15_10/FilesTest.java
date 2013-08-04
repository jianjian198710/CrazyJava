package codes15_10;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest {
	/**
	 * �yԇFiles�,ԓ��ṩ�˴����ķ���������ļ��}�u,�xȡ,����ȃ���
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Path path = Paths.get("ch15/codes15_10/FilesTest.java");
		//�}�u�ļ�����
		Files.copy(path,new FileOutputStream("a.txt"));
		System.out.println("FilesTest.java�Ƿ�Ϊ�����ļ�:"+Files.isHidden(path));
		//�xȡ�ļ�������
		List<String> lines = Files.readAllLines(path, Charset.forName("GBK"));
		System.out.println(lines);
		System.out.println("FilesTest.java�Ĵ�СΪ:"+Files.size(path));
		List<String> poem = new ArrayList<String>();
		poem.add("Fuck!");
		poem.add("You!");
		//����������
		Files.write(Paths.get("poem.txt"), poem, Charset.forName("GBK"));
		FileStore cStore = Files.getFileStore(Paths.get("C:"));
		System.out.println("C:���пռ�"+cStore.getTotalSpace());
		System.out.println("C:���ÿռ�"+cStore.getUsableSpace());
		
	}

}
