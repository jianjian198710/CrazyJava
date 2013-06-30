package codes7_3;

public class StringBuilderTest {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Java");
		sb.insert(0, "Hello ");
		sb.replace(5, 6, ",");
		sb.delete(5, 6);
		sb.reverse();
		System.out.println(sb.toString());
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		
		sb.setLength(5);
		System.out.println(sb.toString());
	}

}
