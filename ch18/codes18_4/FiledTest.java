package codes18_4;

import java.lang.reflect.Field;

public class FiledTest {

	public static void main(String[] args) throws Exception {
		Person p = new Person();
		Class<Person> personClazz = Person.class;
		//��ȡPerson��name Field getDeclaredFiled���Ի�ȡ���е�Field ��getFieldֻ�ܻ�ȡpublic��
		Field nameField = personClazz.getDeclaredField("name");
		//ֻ��ͨ��������ʸ�Fieldʱȡ����������
		nameField.setAccessible(true);
		//����set����Ϊp�����name Field��ֵ
		nameField.set(p, "jianjian");
		Field ageField = personClazz.getDeclaredField("age");
		ageField.setAccessible(true);
		//ͨ��setInt����Ϊp�����age Field��ֵ
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