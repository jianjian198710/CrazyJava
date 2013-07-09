package codes8_4;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {

	/**
	 * �yԇListIterator��һЩ���� hasPrevious(),previous(),add()
	 */
	public static void main(String[] args) {
		String[] books ={"Crazy Java!","Crazy Ajax"};
		List<String> booklist = new ArrayList<String>();
		for(int i=0;i<books.length;i++){
			booklist.add(books[i]);
		}
		ListIterator<String> lit = booklist.listIterator();
		while(lit.hasNext()){
			System.out.println(lit.next());
			//�ֱ���Crazy Java��Crazy Ajax���---------------
			lit.add("--------------------");
		}
		while(lit.hasPrevious()){
			System.out.println(lit.previous());
		}
	}

}
