package codes7_4;

import java.util.Calendar;

public class LazyTest {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2003, 7, 31);
		c.set(Calendar.MONTH, 8);
		//����h������ ����ݔ��2003-9-5 ���h��ݔ��2003-10-01 -> 2003-10-5
		System.out.println(c.getTime());
		c.set(Calendar.DATE, 5);
		System.out.println(c.getTime());
	}

}
