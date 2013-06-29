package codes7_2;

public class IdentityHashCodeTest {

	public static void main(String[] args) {
		String s1 = new String("Hello!");
		String s2 = new String("Hello!");
		//String类本身已经override了hashcode()方法，根据字符顺序进行计算
		System.out.println(s1.hashCode()+"-----"+s2.hashCode());
		//System.identityHashCode()根据对象地址计算，每个都不同
		System.out.println(System.identityHashCode(s1)+"-----"+System.identityHashCode(s2));
	}

}
