package codes15_8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeMutable {
	/**
	 * 當序列化一個可變對象時,只有第一次使用writeObject()方法輸出時才會將該對象轉換成字節序列并輸出,
	 * 當程序再次調用writeObject()方法時,只是輸出序列化編號,
	 * 即使後面該對象的Field值被改變,改變的Field的值也不會被輸出
	 */
	public static void main(String[] args) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mutable.txt"));
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mutable.txt"))){
				Person per = new Person("Sun",500);
				oos.writeObject(per);
				per.setName("Tang");
				oos.writeObject(per);
				Person per1 = (Person)ois.readObject();
				Person per2 = (Person)ois.readObject();
				System.out.println(per1==per2);
				//即使後面該對象的Field值被改變,改變的Field的值也不會被輸出
				System.out.println(per2.getName());
		}catch(IOException ioe){
			ioe.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
