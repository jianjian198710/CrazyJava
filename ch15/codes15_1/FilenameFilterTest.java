package codes15_1;

import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterTest {
	/**
	 * 測試FilenameFilter,該接口包含了一個accept(File dir,String name)方法
	 * File類的list()方法可以接收一個FilenameFilter參數
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
