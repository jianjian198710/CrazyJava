package codes9_4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUtils {

	/**
	 * 測試通配符下限<? super T>
	 */
	public static <T> T copy(Collection<? super T> dest, Collection<T> src){
		T last = null;
		for(T ele:src){
			last = ele;
			//爲什麽這裡可以加進去,dest沒法確定類型啊！！！！！！！
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
