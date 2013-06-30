package codes7_3;

import java.math.BigDecimal;

public class BigDecimalTest {

	public static void main(String[] args) {
		//通常Double和Float的計算會丟失精度 使用BigDecimal可以避免次情況 通常使用String作為構造參數
		System.out.println("0.05+0.01 = "+(0.05+0.01));
		System.out.println("1.0-0.42 = "+(1.0-0.42));
		System.out.println("4.015*100 = "+(4.015*100));
		System.out.println("123.3/100 = "+(123.3/100));
		
		BigDecimal f1 = new BigDecimal("0.05");
		BigDecimal f2 = new BigDecimal("0.01");
		BigDecimal f3 = new BigDecimal(0.05);
		System.out.println("Use the String as the Parameter of the constructure of the BigDecimal");
		System.out.println("0.05+0.01 = "+f1.add(f2));
		System.out.println("0.05-0.01 = "+f1.subtract(f2));
		System.out.println("0.05*0.01 = "+f1.multiply(f2));
		System.out.println("0,05/0.01 = "+f1.divide(f2));
		
		System.out.println("Use the Double as the Parameter of the constructure of the BigDecimal");
		System.out.println("0.05+0.01 = "+f3.add(f2));
		System.out.println("0.05-0.01 = "+f3.subtract(f2));
		System.out.println("0.05*0.01 = "+f3.multiply(f2));
		System.out.println("0,05/0.01 = "+f3.divide(f2));
	}

}
