package codes7_3;

import java.math.BigDecimal;

/**
 * @author JianJian
 * @date 2013.6.29
 * This class is a util class to calculator the Double
 */
public class Arith {
	private static final int DEF_DIV_SCALE = 10;
	private Arith(){};
	
	/**
	 * Add
	 * @param x
	 * @param y
	 * @return x+y
	 */
	public static double add(double x, double y){
		BigDecimal b1 = BigDecimal.valueOf(x);
		BigDecimal b2 = BigDecimal.valueOf(y);
		return b1.add(b2).doubleValue();
	}
	
	/**
	 * Minus
	 * @param x
	 * @param y
	 * @return x-y
	 */
	public static double minus(double x, double y){
		BigDecimal b1 = BigDecimal.valueOf(x);
		BigDecimal b2 = BigDecimal.valueOf(y);
		return b1.subtract(b2).doubleValue();
	}
	
	/**
	 * Multiply
	 * @param x
	 * @param y
	 * @return x*y
	 */
	public static double multiply(double x, double y){
		BigDecimal b1 = BigDecimal.valueOf(x);
		BigDecimal b2 = BigDecimal.valueOf(y);
		return b1.multiply(b2).doubleValue();
	}
	
	/**
	 * Divide 截取小數點后十位 最後一位使用四捨五入
	 * @param x
	 * @param y
	 * @return x/y 
	 */
	public static double divide(double x, double y){
		BigDecimal b1 = BigDecimal.valueOf(x);
		BigDecimal b2 = BigDecimal.valueOf(y);
		return b1.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	
	
}
