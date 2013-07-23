package codes14_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ErrorUtils {
	/**
	 * úy‘á∂—Œ€»æ≈c@SafeVarages
	 */
	public static void faultyMethod(List<String>... listStrArray){
		List[] listArray = listStrArray;
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(new Random().nextInt(100));
		listArray[0] = myList;
		String s = listStrArray[0].get(0);
	}
	public static void main(String[] args) {
		ErrorUtils.faultyMethod(Arrays.asList("Hello!"),Arrays.asList("World!"));
	}

}
