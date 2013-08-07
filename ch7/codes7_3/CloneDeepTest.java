package codes7_3;
/*
 * 進行深度克隆,需要自己進行遞歸克隆,即保證所有引用類型的Field值所引用的對象都被複製了
 */
public class CloneDeepTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		UserDeep user1 = new UserDeep(29);
		UserDeep user2 = user1.clone();
		user2.address = user1.address.clone();
		
		System.out.println(user1 == user2);
		System.out.println(user1.address == user2.address);

	}

}

class AddressDeep implements Cloneable{
	String detail;
	public AddressDeep(String detail){
		this.detail = detail;
	}
	
	//保證UserDeep對象的AddressDeep引用也克隆
	public AddressDeep clone() throws CloneNotSupportedException{
		return (AddressDeep)super.clone();
	}
}

class UserDeep implements Cloneable{
	int age;
	AddressDeep address;
	public UserDeep(int age){
		this.age = age;
		address = new AddressDeep("Shanghai");
	}
	
	public UserDeep clone() throws CloneNotSupportedException{
		return (UserDeep)super.clone();
	}
}