package codes7_3;

import org.junit.Test;

public class ArithTest {

	double x = 2.0;
	double y = 0.3;
	@Test
	public void testAdd() {
		System.out.println(Arith.add(x, y));
	}

	@Test
	public void testMinus() {
		System.out.println(Arith.minus(x, y));
	}

	@Test
	public void testMultiply() {
		System.out.println(Arith.multiply(x, y));
	}

	@Test
	public void testDivide() {
		System.out.println(Arith.divide(x, y));
	}

}
