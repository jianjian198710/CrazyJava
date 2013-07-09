package codes8_4;

import java.util.ArrayList;
import java.util.List;

public class ListTest2 {

	/**
	 * 測試List判斷兩個對象相等只要通過equals()方法比較返回true即可
	 */
	public static void main(String[] args) {
		List<String> books = new ArrayList<String>();
		books.add(new String("Crazy Java!"));
		books.add(new String("Crazy Ajax!"));
		books.add(new String("Fuck Erlang!"));
		System.out.println(books);
		//第一個元素將被刪除
		books.remove(new B());
		System.out.println(books);
		//第二個元素將被刪除
		books.remove(new B());
		System.out.println(books);
	}

}

class B{
	public boolean equals(Object obj){
		return true;
	}
}