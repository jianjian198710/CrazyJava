package codes9_4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUtils {

	/**
	 * �yԇͨ�������<? super T>
	 */
	public static <T> T copy(Collection<? super T> dest, Collection<T> src){
		T last = null;
		for(T ele:src){
			last = ele;
			//��ʲ���@�e���Լ��Mȥ,dest�]���_����Ͱ���������������
			dest.add(ele);
		}
		return last;
	}
	
	public static void main(String[] args) {
		List<Number> ln = new ArrayList<Number>();
		List<Integer> li = new ArrayList<Integer>();
		li.add(5);
		Integer last = copy(ln,li);
		System.out.println(last);
	}
}
