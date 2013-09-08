package codes18_4;

import java.lang.reflect.Field;

public class FiledTest {

	public static void main(String[] args) throws Exception {
		Person p = new Person();
		Class<Person> personClazz = Person.class;
		//获取Person的name Field getDeclaredFiled可以获取所有的Field 而getField只能获取public的
		Field nameField = personClazz.getDeclaredField("name");
		//只是通过反射访问该Field时取消访问限制
		nameField.setAccessible(true);
		//调用set方法为p对象的name Field设值
		nameField.set(p, "jianjian");
		Field ageField = personClazz.getDeclaredField("age");
		ageField.setAccessible(true);
		//通过setInt方法为p对象的age Field设值
		ageField.setInt(p, 26);
		System.out.println(p);
	}

}

class Person{
	private String name;
	private int age;
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}