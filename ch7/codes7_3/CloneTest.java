package codes7_3;
/*
 * Object��ṩ��һ��protected clone()����,�õ�һ����ǰ����ĸ���,����֮�g��ȫ���x
 * ��ֻ��һ�N�\��¡,ֻ��¡ԓ���������Fieldֵ,�������������Fieldֵ�����õČ����M�п�¡
 */
public class CloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		User user1 = new User(29);
		User user2 = user1.clone();
		
		//��¡���Č���ֻ��ԭ�Ќ���ĸ���,����false
		System.out.println(user1 == user2);
		/*
		 * Object��ṩ��Clone�C��ֻ���������������׃���M�к����}�u,�������׃����������������,
		 * Object��Clone�C��Ҳֻ�Ǻ��ε��}�u�@������׃��,
		 * �@��ԭ�Ќ����������͵Č���׃���c��¡�����������͵Č���׃����Ȼָ��ȴ��е�ͬһ������
		 */
		System.out.println(user1.address == user2.address);

	}

}

class Address{
	String detail;
	public Address(String detail){
		this.detail = detail;
	}
}

class User implements Cloneable{
	int age;
	Address address;
	public User(int age){
		this.age = age;
		address = new Address("Shanghai");
	}
	
	public User clone() throws CloneNotSupportedException{
		//ͨ�^�{��super.clone()�팍�Fclone()����
		return (User)super.clone();
	}
}