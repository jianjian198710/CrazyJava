package codes8_3;

import java.util.TreeSet;

public class TreeSetTest2 {

	/**
	 * ���TreeSet���ԣ����Д��ɂ������Ƿ���ȵ�Ψһ�˜��ǣ��ɂ�����ͨ�^compareTO() �������^�Ƿ񷵻�0
	 */
	public static void main(String[] args) {
		TreeSet<Z> ts = new TreeSet<Z>();
		Z z1 = new Z(6);
		Z z2 = new Z(2);
		System.out.println(z1.equals(z2));
		//��鏊��׌compareTo����ݔ��0,����ֻ�е�һ���ӵ���TreeSet��
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

	// ǿ�ƱȽ����1
	public int compareTo(Z z) {
		return 0;
	}

	public String toString() {
		return String.valueOf(this.age);
	}
}