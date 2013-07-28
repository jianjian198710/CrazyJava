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
					//ʹ��Java 5�ṩ��enumt�������κΆ��}
					Orientation or1 = Orientation.valueOf(Orientation.class, "VERTICAL");
					oos.writeObject(Orientation.VERTICAL);
					Orientation or2 = (Orientation)ois.readObject();
					System.out.println(or2==or1);
					/*
					 * ʹ��Java 5��ǰ��ö�e���,ori3��һ���µ�Oritentation2����,
					 * �������Orientation2����κ�ö�eֵ,���ö�e�Ҫ��readResovle()����,
					 * ԓ�����ķ���ֵ�������ԭ�����л��Č���,ԭ��Č�����������G��
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
