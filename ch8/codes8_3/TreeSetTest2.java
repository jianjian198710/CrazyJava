package codes8_3;

import java.util.TreeSet;

public class TreeSetTest2 {

	/**
	 * 對於TreeSet而言，它判斷兩個對象是否相等的唯一標準是，兩個對象通過compareTO() 方法比較是否返回0
	 */
	public static void main(String[] args) {
		TreeSet<Z> ts = new TreeSet<Z>();
		Z z1 = new Z(6);
		Z z2 = new Z(2);
		System.out.println(z1.equals(z2));
		//因為強制讓compareTo方法輸出0,所以只有第一個加到了TreeSet中
		ts.add(z1);
		ts.add(z2);
		System.out.println(ts);
	}

}

class Z implements Comparable<Z> {
	int age;

	public Z(int age) {
		this.age = age;
	}

	public boolean equals(Object obj) {
		return false;
	}

	// 强制比较输出1
	public int compareTo(Z z) {
		return 0;
	}

	public String toString() {
		return String.valueOf(this.age);
	}
}