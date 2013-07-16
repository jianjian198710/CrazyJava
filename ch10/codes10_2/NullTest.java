package codes10_2;

import java.util.Date;

public class NullTest {
	/**
	 * úy‘áø’÷∏·òÆê≥£
	 */
	public static void main(String[] args) {
		Date d = null;
		try{
			System.out.println(d.after(new Date()));
		}catch(NullPointerException e){
			System.out.println("NullPointer Exception!");
		}catch(Exception e){
			System.out.println("Unknown Exception!");
		}
	}

}
