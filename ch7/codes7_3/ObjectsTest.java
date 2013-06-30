package codes7_3;

import java.util.Objects;

public class ObjectsTest {

	static ObjectsTest obj;
	public static void main(String[] args) {
		System.out.println(Objects.toString(obj));
		System.out.println(Objects.hashCode(obj));
		//requireNonNull()當傳入的參數不為null 返回參數本省 否則報NullPointerException
		System.out.println(Objects.requireNonNull(obj,"The parameter can't be null!"));
	}
}
