package codes8_4;

import java.util.ArrayList;
import java.util.List;

public class ListTest2 {

	/**
	 * �yԇList�Д��ɂ��������ֻҪͨ�^equals()�������^����true����
	 */
	public static void main(String[] args) {
		List<String> books = new ArrayList<String>();
		books.add(new String("Crazy Java!"));
		books.add(new String("Crazy Ajax!"));
		books.add(new String("Fuck Erlang!"));
		System.out.println(books);
		//��һ��Ԫ�،����h��
		books.remove(new B());
		System.out.println(books);
		//�ڶ���Ԫ�،����h��
		books.remove(new B());
		System.out.println(books);
	}

}

class B{
	public boolean equals(Object obj){
		return true;
	}
}