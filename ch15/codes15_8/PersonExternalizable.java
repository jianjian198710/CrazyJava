package codes15_8;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
/*
 * 實現Externalizable接口的自定義序列化,必須實現writeExternal()和readExternal()方法
 * 該方法調用DataOutput/DataInput的方法
 */
public class PersonExternalizable implements Externalizable{
	private String name;
	private int age;
	
	public PersonExternalizable(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public PersonExternalizable(){}
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

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(new StringBuffer(name).reverse());
		out.writeInt(age);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		this.name = ((StringBuffer)in.readObject()).reverse().toString();
		this.age = in.readInt();
	}
	
	
}
