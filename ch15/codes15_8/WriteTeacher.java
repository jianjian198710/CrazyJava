package codes15_8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteTeacher {
	/**
	 * 如果使用序列化向文件寫入了多個Java對象,反序列化必須按實際寫入的順序讀取
	 * Java序列化機制採用了一種特殊的序列化算法
	 * (1)所有保存到磁盤的對象都有一個序列化編號
	 * (2)當程序試圖序列化一個對象時,程序將先檢查該對象是否已經被序列化過,只有該對象從未
	 * (在本次JVM中)被序列化過,系統才會將該對象轉換成字節序列并輸出
	 * (3)如果某個對象已經序列化過,程序只是直接輸出一個序列化編號,而不是再次序列化
	 */
	public static void main(String[] args) {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("teacher.txt"))) {
			Person person = new Person("Sun", 50);
			Teacher teacher1 = new Teacher("Tang", person);
			Teacher teacher2 = new Teacher("Pu", person);
			//第一次序列化,連同Person一起轉換成字節序列
			oos.writeObject(teacher1);
			//第一次序列化,但是Person直接輸出序列號
			oos.writeObject(teacher2);
			//直接輸出序列號
			oos.writeObject(person);
			//直接輸出序列號
			oos.writeObject(teacher2);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
