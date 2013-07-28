package codes15_8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersonExternalizableTest {
	/**
	 * œyÔ‡PersonExternalizableºÍPersonSerializablePersonally
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"));
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"))){
			
				PersonExternalizable person1 = new PersonExternalizable("Sun", 500);
				PersonSerializablePersonally person2 = new PersonSerializablePersonally("Sun", 500);
				
				oos.writeObject(person1);
				oos.writeObject(person2);
				
				PersonExternalizable person3 = (PersonExternalizable)ois.readObject();
				PersonSerializablePersonally person4 = (PersonSerializablePersonally)ois.readObject();
				
				System.out.println(person3.getAge()+person3.getName());
				System.out.println(person4.getAge()+person4.getName());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
