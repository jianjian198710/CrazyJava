package codes14_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
/*
 * (1)4个基本的annotation @Override @Deprecated @SuppressWarnings @SafeVarargs
 * @SuppressWarnings指示该Annotation修饰的程序元素取消显示的编译器警告
 * @SafeVarargs是Java7专门为抑制"堆污染"警告提供的
 * 
 * (2)JDK元Annotation
 * @Retention @Target @Documented @Inherited
 */
public class ErrorUtils {
	/**
	 * 測試堆污染與@SafeVarages
	 */
	//Java不允许创建泛型数组,因此listStrArray只能被当做List[]来处理,相当于把List<String>赋给了List,已经产生堆污染
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
