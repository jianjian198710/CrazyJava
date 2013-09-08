package codes15_1;

import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterTest {

	public static void main(String[] args) {
		File file = new File(".");
		/*
		 * File���list()�����п��Խ���һ��FilenameFilter�ӿ���Ϊ����
		 * ԓ�ӿڰ�����һ��accept(File dir,String name)����
		 */
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
