package codes7_3;

import java.util.Arrays;
import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		//ʹ�î�ǰ�r�g����N���Ա�����S�C�ĳ��F
		Random rand = new Random(System.currentTimeMillis());
		System.out.println("rand.nextBoolean(): "+rand.nextBoolean());
		
		byte[] bytes = new byte[16];
		rand.nextBytes(bytes);
		System.out.println("bytes: "+Arrays.toString(bytes));
		
		System.out.println("Gaussian: "+rand.nextGaussian());
	}

}
