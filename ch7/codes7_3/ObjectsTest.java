package codes7_3;

import java.util.Objects;

public class ObjectsTest {
	/*
	 * �yԇObjects�,ԓ���Ҫ�ṩ��һЩ���߷������������,
	 * �@Щ���߷��������"��ָ�"��ȫ��
	 */
	static ObjectsTest obj;
	public static void main(String[] args) {
		//ݔ��һ��null�����toString,ݔ��null
		System.out.println(Objects.toString(obj));
		//ݔ��һ��null�����hashCodeֵ,ݔ��0
		System.out.println(Objects.hashCode(obj));
		//requireNonNull()������ą�������null ���؅�����ʡ ��t��NullPointerException
		System.out.println(Objects.requireNonNull(obj,"The parameter can't be null!"));
	}
}
