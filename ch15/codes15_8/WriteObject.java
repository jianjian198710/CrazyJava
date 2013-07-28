package codes15_8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
	/**
	 * �yԇSerializable�ӿڵĶ���writeObject()����
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
