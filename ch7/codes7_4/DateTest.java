package codes7_4;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date date1 = new Date();
		Date date2 = new Date(System.currentTimeMillis()+1000);
		System.out.println(date1);
		System.out.println(date2);
		System.out.println(date1.compareTo(date2));
		System.out.println(date1.before(date2));
	}

}
