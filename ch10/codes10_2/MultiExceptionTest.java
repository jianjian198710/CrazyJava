package codes10_2;

public class MultiExceptionTest {
	/**
	 * 當捕獲多個異常時 ,異常變量有隱式的final修飾符,因此程序不能對異常變量重新賦值，
	 * 捕獲單個異常則沒有這種情況
	 */
	public static void main(String[] args) {
		try{
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int c = a/b;
			System.out.println(c);
		}catch(IndexOutOfBoundsException|NumberFormatException|ArithmeticException e){
			System.out.println("One of Three Exceptions!");
			//捕獲多異常,異常變量不能賦值
//			e = new ArithmeticException("test");
		}catch(Exception e){
			System.out.println("Unknown Exception!");
			//捕獲單異常,異常變量可以賦值
			e = new RuntimeException("test");
		}
		
	}

}
