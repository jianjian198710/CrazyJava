package codes8_3;

import java.util.TreeSet;
/*
 * (1)TreeSet��SortedSet�ӿڵ�ʵ����
 * (2)TreeSet���ú���������ݽṹ���洢����Ԫ��,TreeSet֧���������򷽷�:��Ȼ����Ͷ�������
 * 	  ��Ȼ����:TreeSet����ü���Ԫ�ص�compareTo(Object obj)����(����Comparable�ӿ�)���Ƚ�Ԫ��֮��Ĵ�С�Ĺ�ϵ
 * (3)��TreeSet����ӵ�Ӧ����ͬһ����Ķ���,ͬһ����Ķ�����ܽ��бȽ�
 * 
 */
public class TreeSetTest {

	public static void main(String[] args) {
		TreeSet<Integer> nums = new TreeSet<Integer>();
		nums.add(5);
		nums.add(2);
		nums.add(10);
		nums.add(-9);
		System.out.println(nums);
		System.out.println(nums.first());
		System.out.println(nums.last());
		System.out.println(nums.headSet(4));
		System.out.println(nums.tailSet(5));
		System.out.println(nums.lower(8));
		System.out.println(nums.higher(8));

	}

}
