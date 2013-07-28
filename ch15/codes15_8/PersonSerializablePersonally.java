package codes15_8;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/*
 * 自定義序列化,需實現wirteObject()和readObject()方法
 */
public class PersonSerializablePersonally implements Serializable{
	private static final long serialVersionUID = -2983421696923835938L;
	private String name;
	private int age;
	
	public PersonSerializablePersonally(String name, int age) {
		super();
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
	
	private void writeObject(ObjectOutputStream oos) throws IOException{
		oos.writeObject(new StringBuffer(name).reverse());
		oos.writeInt(age);
	}
	
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException{
		this.name = ((StringBuffer)ois.readObject()).reverse().toString();
		this.age = ois.readInt();
	}
}
