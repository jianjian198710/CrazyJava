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
	 * 測試Files類,該類提供了大量的方法來完成文件複製,讀取,寫入等內容
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Path path = Paths.get("ch15/codes15_10/FilesTest.java");
		//複製文件內容
		Files.copy(path,new FileOutputStream("a.txt"));
		System.out.println("FilesTest.java是否为隐藏文件:"+Files.isHidden(path));
		//讀取文件所有行
		List<String> lines = Files.readAllLines(path, Charset.forName("GBK"));
		System.out.println(lines);
		System.out.println("FilesTest.java的大小为:"+Files.size(path));
		List<String> poem = new ArrayList<String>();
		poem.add("Fuck!");
		poem.add("You!");
		//寫入所有行
		Files.write(Paths.get("poem.txt"), poem, Charset.forName("GBK"));
		FileStore cStore = Files.getFileStore(Paths.get("C:"));
		System.out.println("C:共有空间"+cStore.getTotalSpace());
		System.out.println("C:可用空间"+cStore.getUsableSpace());
		
	}

}
