package codes8_8;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsTest {
	/**
	 * �yԇCollections��е�һЩstatic����
	 */
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		nums.add(-5);
		nums.add(3);
		nums.add(0);
		System.out.println(nums);
		
		System.out.print("Collections.reverse: ");
		Collections.reverse(nums);
		System.out.println(nums);
		
		System.out.print("Collections.sort: ");
		Collections.sort(nums);
		System.out.println(nums);
		//��List����Ԫ�ؽ����漴����
		System.out.print("Collections.shuffle: ");
		Collections.shuffle(nums);
		System.out.println(nums);
		
		System.out.print("Collections.rotate: ");
		Collections.rotate(nums, 2);
		System.out.println(nums);
		
		System.out.print("Collections.max: ");
		System.out.println(Collections.max(nums));
		System.out.print("Collections.min: ");
		System.out.println(Collections.min(nums));
		//ʹ��һ����ֵnewVal�滻List��������о�ֵoldVal
		System.out.print("Collections.repalceAll: ");
		System.out.println(Collections.replaceAll(nums, 0, 1));
		
		System.out.print("Collections.frequency: ");
		System.out.println(Collections.frequency(nums, -5));
		
		Collections.sort(nums);
		System.out.println(nums);
		System.out.println(Collections.binarySearch(nums, 3));
	}
}
