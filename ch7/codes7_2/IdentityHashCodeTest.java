package codes7_2;

public class IdentityHashCodeTest {

	public static void main(String[] args) {
		String s1 = new String("Hello!");
		String s2 = new String("Hello!");
		//String�౾���Ѿ�override��hashcode()�����������ַ�˳����м���
		System.out.println(s1.hashCode()+"-----"+s2.hashCode());
		//System.identityHashCode()���ݶ����ַ���㣬ÿ������ͬ
		System.out.println(System.identityHashCode(s1)+"-----"+System.identityHashCode(s2));
	}

}
