package codes7_4;

import java.util.Calendar;
/*
 * Calendar所代表的时间不会立即修改,等到下次调用get(),getTime(),getTimeinMillis(),add(),roll()时才会重新计算
 */
public class LazyTest {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2003, 7, 31);
		c.set(Calendar.MONTH, 8);
		//如果刪除该行 最後輸出2003-10-5 不刪除輸出2003-10-01(9-31不存在)
		System.out.println(c.getTime());
		c.set(Calendar.DATE, 5);
		System.out.println(c.getTime());
	}

}
