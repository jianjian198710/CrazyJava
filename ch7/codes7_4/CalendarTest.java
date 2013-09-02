package codes7_4;

import java.util.Calendar;
/*
 * (1)Calendar类本身是一个抽象类,程序只能创建其子类的实例
 * (2)Calendar与Date可以自由转换 Date date = calendar.getTime(); calendar.setTime(date);
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
		 * add(int field,int amount)有两条规则
		 * (1)当被修改的字段超出它允许的范围时,会发生进位,即一级的字段也会增大 2003-8-23 +6months 2004-2-23
		 * (2)如果下一级字段也需要改变,那么该字段会修正到变化最小的值 2003-8-31 +6months 2004-2-29
		 */
		c.add(Calendar.YEAR, -1);
		System.out.println(c.getTime());
		/*
		 * roll与add相反 当被修改的范围超出它允许的范围内,上一级字段不会增大 2003-8-23 +6months 2003-2-23
		 * 下一级字段处理规则与add相似
		 */
		c.roll(Calendar.MONTH, -8);
		System.out.println(c.getTime());
		/*
		 * Calendar提供了一个setLenient()方法类设置容错性,默认打开,可理解为自动进位,比如月份输入13,年份自动+1,如果关闭就会报错
		 */
		c.setLenient(false);
		
	}

}
