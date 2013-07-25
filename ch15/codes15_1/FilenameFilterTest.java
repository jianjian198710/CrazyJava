package codes15_1;

import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterTest {
	/**
	 * �yԇFilenameFilter,ԓ�ӿڰ�����һ��accept(File dir,String name)����
	 * File�list()�������Խ���һ��FilenameFilter����
	 */
	public static void main(String[] args) {
		File file = new File(".");
		String[] nameList = file.list(new FilenameFilter(){
			public boolean accept(File dir,String name){
				return name.endsWith(".java")||new File(name).isDirectory();
			}
		});
		for(String name:nameList){
			System.out.println(name);
		}
	}
}
