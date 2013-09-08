package codes15_1;

import java.io.File;
import java.io.IOException;

public class FileTest {
	/**
	 * 不管是文件还是目录都是使用File来操作的
	 */
	public static void main(String[] args) throws IOException {
		//file指代相對路徑當前目錄,即根目錄..
		File file = new File(".");
		//退出JVM時自動刪除該文件
		file.deleteOnExit();
		//獲取文件名
		System.out.println(file.getName());
		//獲取相對路徑的父路徑
		System.out.println(file.getParent());
		//獲取絕對路徑
		System.out.println(file.getAbsolutePath());
		//獲取上一級路徑
		System.out.println(file.getAbsoluteFile().getParent());
		
		File newFile = new File(System.currentTimeMillis()+"");
		System.out.println("newFile是否存在:"+newFile.exists());
		System.out.println(newFile.createNewFile());
		newFile.deleteOnExit();
		
		System.out.println(file.mkdir());
		//list()方法列出當前路徑下所有文件和路徑
		for(String fileName:file.list()){
			System.out.println(fileName);
		}
		System.out.println("=======系統所有根路徑如下========");
		//listRoots()靜態方法列出所有磁盤根路徑
		for(File root:File.listRoots()){
			System.out.println(root);
		}
		
	}

}
