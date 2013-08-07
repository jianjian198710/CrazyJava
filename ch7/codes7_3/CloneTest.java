package codes7_3;
/*
 * Object類提供了一個protected clone()方法,得到一個當前對象的副本,兩者之間完全隔離
 * 它只是一種淺克隆,只克隆該對象的所有Field值,不會對引用類型Field值所引用的對象進行克隆
 */
public class CloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		User user1 = new User(29);
		User user2 = user1.clone();
		
		//克隆出的對象只是原有對象的副本,返回false
		System.out.println(user1 == user2);
		/*
		 * Object類提供的Clone機制只對對象里各個實例變量進行簡單複製,如果實例變量的類型是引用類型,
		 * Object的Clone機制也只是簡單地複製這個引用變量,
		 * 這樣原有對象的引用類型的實例變量與克隆對象的引用類型的實例變量依然指向內存中的同一個實例
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
		//通過調用super.clone()來實現clone()方法
		return (User)super.clone();
	}
}