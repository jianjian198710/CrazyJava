package codes7_4;

import java.util.Calendar;
/*
 * Calendar�������ʱ�䲻�������޸�,�ȵ��´ε���get(),getTime(),getTimeinMillis(),add(),roll()ʱ�Ż����¼���
 */
public class LazyTest {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2003, 7, 31);
		c.set(Calendar.MONTH, 8);
		//����h������ ����ݔ��2003-10-5 ���h��ݔ��2003-10-01(9-31������)
		System.out.println(c.getTime());
		c.set(Calendar.DATE, 5);
		System.out.println(c.getTime());
	}

}
