package codes7_3;

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