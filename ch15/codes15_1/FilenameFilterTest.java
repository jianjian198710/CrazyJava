package codes15_1;

import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterTest {

	public static void main(String[] args) {
		File file = new File(".");
		/*
		 * File类的list()方法中可以接收一个FilenameFilter接口作为参数
		 * 該接口包含了一個accept(File dir,String name)方法
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
