package codes15_8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"))){
			Person p = (Person)ois.readObject();
			System.out.println("Name: "+p.getName()+", Age: "+p.getAge());
		}catch(IOException ioe){
			ioe.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
