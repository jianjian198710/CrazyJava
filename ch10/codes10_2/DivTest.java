package codes10_2;

public class DivTest {
	/**
	 * œyÔ‡Exception
	 */
	public static void main(String[] args) {
		try{
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int c = a/b;
			System.out.println(c);
		}catch(IndexOutOfBoundsException e){
			System.out.println("IndexOutOfBoundsException!");
		}catch(NumberFormatException e){
			System.out.println("NumberFormatException£¡");
		}catch(ArithmeticException e){
			System.out.println("ArithmeticException£¡");
		}catch(Exception e){
			System.out.println("Unknown Exception!");
		}
	}

}
