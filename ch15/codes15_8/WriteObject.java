package codes15_8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
	/**
	 * 測試Serializable接口的定制writeObject()方法
	 */
	public static void main(String[] args) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"))){
			Person person = new Person("Boddy",50);
			oos.writeObject(person);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
}
