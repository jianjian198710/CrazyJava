package codes15_8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadTeacher {
	/**
	 * �����л��xȡ�ăH�H��Java����Ĕ���,������Java����
	 */
	public static void main(String[] args) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teacher.txt"))){
			Teacher t1 =(Teacher)ois.readObject();
			Teacher t2 =(Teacher)ois.readObject();
			Person p = (Person)ois.readObject();
			Teacher t3 = (Teacher)ois.readObject();
			System.out.println(t1.getStudent() == p);
			System.out.println(t2.getStudent() == p);
			System.out.println(t2 == t3);
		}catch(IOException ioe){
			ioe.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
