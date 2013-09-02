package codes7_4;

import java.util.Calendar;
/*
 * (1)Calendar�౾����һ��������,����ֻ�ܴ����������ʵ��
 * (2)Calendar��Date��������ת�� Date date = calendar.getTime(); calendar.setTime(date);
 * 
 */
public class CalendarTest {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());
		System.out.println("Year: "+c.get(Calendar.YEAR));
		//MONTH 0->Jan 1->Feb 2->Mar....
		System.out.println("Month: "+c.get(Calendar.MONTH));
		System.out.println("Day: "+c.get(Calendar.DATE));
		
		c.set(2003, 10, 23, 12, 23, 23);
		System.out.println("The Date is: "+c.getTime());
		/*
		 * add(int field,int amount)����������
		 * (1)�����޸ĵ��ֶγ���������ķ�Χʱ,�ᷢ����λ,��һ�����ֶ�Ҳ������ 2003-8-23 +6months 2004-2-23
		 * (2)�����һ���ֶ�Ҳ��Ҫ�ı�,��ô���ֶλ��������仯��С��ֵ 2003-8-31 +6months 2004-2-29
		 */
		c.add(Calendar.YEAR, -1);
		System.out.println(c.getTime());
		/*
		 * roll��add�෴ �����޸ĵķ�Χ����������ķ�Χ��,��һ���ֶβ������� 2003-8-23 +6months 2003-2-23
		 * ��һ���ֶδ��������add����
		 */
		c.roll(Calendar.MONTH, -8);
		System.out.println(c.getTime());
		/*
		 * Calendar�ṩ��һ��setLenient()�����������ݴ���,Ĭ�ϴ�,�����Ϊ�Զ���λ,�����·�����13,����Զ�+1,����رվͻᱨ��
		 */
		c.setLenient(false);
		
	}

}
