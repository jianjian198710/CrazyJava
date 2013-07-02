package codes8_1;
import java.util.HashSet;
import java.util.Set;


public class SetTest {

	public static void main(String[] args) {
		Set<String> books = new HashSet<String>();
		books.add(new String("Hello Java!"));
		boolean result = books.add(new String("Hello Java!"));
		System.out.println(result);
	}

}
