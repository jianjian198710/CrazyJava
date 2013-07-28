package codes15_8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteTeacher {
	/**
	 * ���ʹ�����л����ļ������˶���Java����,�����л���횰����H���������xȡ
	 * Java���л��C�ƒ�����һ�N��������л��㷨
	 * (1)���б��浽�űP�Č�����һ�����л���̖
	 * (2)������ԇ�D���л�һ������r,�����șz��ԓ�����Ƿ��ѽ������л��^,ֻ��ԓ�����δ
	 * (�ڱ���JVM��)�����л��^,ϵ�y�ŕ���ԓ�����D�Q���ֹ����в�ݔ��
	 * (3)���ĳ�������ѽ����л��^,����ֻ��ֱ��ݔ��һ�����л���̖,�������ٴ����л�
	 */
	public static void main(String[] args) {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("teacher.txt"))) {
			Person person = new Person("Sun", 50);
			Teacher teacher1 = new Teacher("Tang", person);
			Teacher teacher2 = new Teacher("Pu", person);
			//��һ�����л�,�BͬPersonһ���D�Q���ֹ�����
			oos.writeObject(teacher1);
			//��һ�����л�,����Personֱ��ݔ������̖
			oos.writeObject(teacher2);
			//ֱ��ݔ������̖
			oos.writeObject(person);
			//ֱ��ݔ������̖
			oos.writeObject(teacher2);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
