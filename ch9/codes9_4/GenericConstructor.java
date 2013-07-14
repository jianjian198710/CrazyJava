package codes9_4;

public class GenericConstructor {

	/**
	 * œyÔ‡·ºÐÍ˜‹ÔìÆ÷
	 */
	public static void main(String[] args) {
		new Foo("Crazy Java");
		new Foo(200);
		new<String> Foo("Crazy Java");
		//new<String> Foo(12.3);
	}

}

class Foo{
	public <T> Foo(T t){
		System.out.println(t);
	}
}
