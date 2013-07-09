package codes8_4;

import java.util.Arrays;
import java.util.List;

public class FixedSizeList {

	/**
	 * 測試Arrays.asList()方法，該方法生成一個Arrays.ArrayList，
	 * 為一個固定長度的List，且不可增加，刪除該集合中的元素
	 */
	public static void main(String[] args) {
		List<String> fixedList = Arrays.asList("Crazy Java","Crazy Ajax");
		System.out.println(fixedList.getClass());
		for(String s:fixedList){
			System.out.println(s);
		}
		//執行下面兩行出現UnsupportedOperationException
		try{
			fixedList.add("Crazy Android");
			fixedList.remove("Crazy Java");
		}catch(UnsupportedOperationException e){
			System.out.println("Can't add or remove");
		}
	}

}
