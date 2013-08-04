package codes15_10;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
	/**
	 * Path接口代表一個平臺無關的平臺路徑
	 */
	public static void main(String[] args) {
		Path path = Paths.get(".");
		System.out.println("path里包含的路徑數量:"+path.getNameCount());
		System.out.println("path根路徑:"+path.getRoot());
		Path absolutePath = path.toAbsolutePath();
		System.out.println(absolutePath);
		System.out.println("absolutePath的根路徑:"+absolutePath.getRoot());
		//其實就是有幾級目錄
		System.out.println("absolutePath包含的路徑數量:"+absolutePath.getNameCount());
		System.out.println(absolutePath.getName(2));
		Path path2 = Paths.get("h:", "Developer");
		System.out.println(path2);
	}

}
