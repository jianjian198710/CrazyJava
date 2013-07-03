package codes8_1;

import java.util.TreeSet;

public class TreeSetTest {

	/**
	 * To test some methods of TreeSet,such as first(),last(),headset(),tailset(),lower(),higher()
	 */
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
