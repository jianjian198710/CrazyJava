package codes7_5;

import java.util.Arrays;

public class StringRegTest {

	public static void main(String[] args) {
		String[] strs = {"Java,has,regular expressions in 1.4",
						"regular expressions now expressing in Java",
						"Java represses oracular expressions"};
		for(String str: strs){
			System.out.println(str.replaceAll("re\\w+", "¹þ¹þ:)"));
			System.out.println(Arrays.toString(str.split("\\s")));
		}
		
	}

}
