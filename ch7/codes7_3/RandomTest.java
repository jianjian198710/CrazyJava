package codes7_3;

import java.util.Arrays;
import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		//使用當前時間作為種子以避免偽隨機的出現
		Random rand = new Random(System.currentTimeMillis());
		System.out.println("rand.nextBoolean(): "+rand.nextBoolean());
		
		byte[] bytes = new byte[16];
		rand.nextBytes(bytes);
		System.out.println("bytes: "+Arrays.toString(bytes));
		
		System.out.println("Gaussian: "+rand.nextGaussian());
	}

}
