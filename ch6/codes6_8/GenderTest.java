package codes6_8;

public class GenderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//无法new一个枚举类,要使用valueOf
		Gender g = Gender.valueOf(Gender.class,"MALE");
		g.setName("Jane");
		System.out.println(g+":"+g.getName());

	}

}
