package codes15_10;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
	/**
	 * Path�ӿڴ���һ��ƽ�_�o�P��ƽ�_·��
	 */
	public static void main(String[] args) {
		Path path = Paths.get(".");
		System.out.println("path�������·������:"+path.getNameCount());
		System.out.println("path��·��:"+path.getRoot());
		Path absolutePath = path.toAbsolutePath();
		System.out.println(absolutePath);
		System.out.println("absolutePath�ĸ�·��:"+absolutePath.getRoot());
		//�䌍�����Ў׼�Ŀ�
		System.out.println("absolutePath������·������:"+absolutePath.getNameCount());
		System.out.println(absolutePath.getName(2));
		Path path2 = Paths.get("h:", "Developer");
		System.out.println(path2);
	}

}
