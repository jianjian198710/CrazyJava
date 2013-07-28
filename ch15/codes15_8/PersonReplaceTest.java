package codes15_8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PersonReplaceTest {
	/**
	 * 测试PersonReplace,将PersonReplace类反序列化成ArrayList
	 */
	public static void main(String[] args) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("replace.txt"));
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("replace.txt"))){
				PersonReplace person = new PersonReplace("Sun",500);
				oos.writeObject(person);
				ArrayList list = (ArrayList)ois.readObject();
				System.out.println(list);
		}catch (IOException ioe){
			ioe.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}

}
