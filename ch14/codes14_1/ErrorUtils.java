package codes14_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
/*
 * (1)4��������annotation @Override @Deprecated @SuppressWarnings @SafeVarargs
 * @SuppressWarningsָʾ��Annotation���εĳ���Ԫ��ȡ����ʾ�ı���������
 * @SafeVarargs��Java7ר��Ϊ����"����Ⱦ"�����ṩ��
 * 
 * (2)JDKԪAnnotation
 * @Retention @Target @Documented @Inherited
 */
public class ErrorUtils {
	/**
	 * �yԇ����Ⱦ�c@SafeVarages
	 */
	//Java����������������,���listStrArrayֻ�ܱ�����List[]������,�൱�ڰ�List<String>������List,�Ѿ���������Ⱦ
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
