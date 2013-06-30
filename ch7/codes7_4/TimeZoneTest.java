package codes7_4;

import java.util.Arrays;
import java.util.TimeZone;

public class TimeZoneTest {

	public static void main(String[] args) {
		//Get all the Timezones
		String[] ids = TimeZone.getAvailableIDs();
		System.out.println(Arrays.toString(ids));
		
		//Get the system's Timezone 
		TimeZone my = TimeZone.getDefault();
		System.out.println(my.getID());
		System.out.println(my.getDisplayName());
		System.out.println(TimeZone.getTimeZone("CMT").getDisplayName());
	}

}
