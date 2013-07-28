package codes15_8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class OrientationTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("orientation.txt"));
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("orientation.txt"))){
					//使用Java 5提供的enum類則不會有任何問題
					Orientation or1 = Orientation.valueOf(Orientation.class, "VERTICAL");
					oos.writeObject(Orientation.VERTICAL);
					Orientation or2 = (Orientation)ois.readObject();
					System.out.println(or2==or1);
					/*
					 * 使用Java 5以前的枚舉類寫法,ori3是一個新的Oritentation2對象,
					 * 而不等於Orientation2類中任何枚舉值,因此枚舉類要寫readResovle()方法,
					 * 該方法的返回值將會替代原來反序列化的對象,原來的對象會被立即丟棄
					 */
					oos.writeObject(Orientation2.VERTICAL);
					Orientation2 or3 = (Orientation2)ois.readObject();
					System.out.println(or3==Orientation2.VERTICAL);
					
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
