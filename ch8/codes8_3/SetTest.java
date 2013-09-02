package codes8_3;
import java.util.HashSet;
import java.util.Set;

/*
 * Set判断两个对象相同不是使用==运算符,而是根据equals方法
 */
public class SetTest {

	public static void main(String[] args) {
		Set<String> books = new HashSet<String>();
		books.add(new String("Hello Java!"));
		boolean result = books.add(new String("Hello Java!"));
		System.out.println(result);
	}

}
