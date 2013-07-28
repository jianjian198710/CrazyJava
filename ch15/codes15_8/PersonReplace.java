package codes15_8;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;

public class PersonReplace implements Serializable{
	private String name;
	private int age;
	
	public PersonReplace(String name, int age) {
		System.out.println("Constructor!");
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	//�����Ҫʵ�����л�ĳ������ʱ����ö���,Ӧ��Ϊʵ�������ṩ���·���
	private Object writeReplace() throws ObjectStreamException{
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(name);
		list.add(age);
		return list;
	}
}
