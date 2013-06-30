package codes7_4;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());
		System.out.println("Year: "+c.get(c.YEAR));
		//MONTH 0->Jan 1->Feb 2->Mar....
		System.out.println("Month: "+c.get(c.MONTH));
		System.out.println("Day: "+c.get(c.DATE));
		
		c.set(2003, 10, 23, 12, 23, 23);
		System.out.println("The Date is: "+c.getTime());
		c.add(c.YEAR, -1);
		System.out.println(c.getTime());
		c.roll(c.MONTH, -8);
		System.out.println(c.getTime());
		
	}

}
