package codes8_4;

import java.util.Arrays;
import java.util.List;

public class FixedSizeList {

	/**
	 * �yԇArrays.asList()������ԓ��������һ��Arrays.ArrayList��
	 * ��һ���̶��L�ȵ�List���Ҳ������ӣ��h��ԓ�����е�Ԫ��
	 */
	public static void main(String[] args) {
		List<String> fixedList = Arrays.asList("Crazy Java","Crazy Ajax");
		System.out.println(fixedList.getClass());
		for(String s:fixedList){
			System.out.println(s);
		}
		//����������г��FUnsupportedOperationException
		try{
			fixedList.add("Crazy Android");
			fixedList.remove("Crazy Java");
		}catch(UnsupportedOperationException e){
			System.out.println("Can't add or remove");
		}
	}

}
