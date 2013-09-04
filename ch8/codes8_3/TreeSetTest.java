package codes8_3;

import java.util.TreeSet;
/*
 * (1)TreeSet是SortedSet接口的实现类
 * (2)TreeSet采用红黑树的数据结构来存储集合元素,TreeSet支持两种排序方法:自然排序和定制排序
 * 	  自然排序:TreeSet会调用集合元素的compareTo(Object obj)方法(来自Comparable接口)来比较元素之间的大小的关系
 * (3)向TreeSet中添加的应该是同一个类的对象,同一个类的对象才能进行比较
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
