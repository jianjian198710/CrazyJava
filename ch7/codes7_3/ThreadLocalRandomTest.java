package codes7_3;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomTest {

	public static void main(String[] args) {
		ThreadLocalRandom tlr = ThreadLocalRandom.current();
		System.out.println(tlr.nextInt());
	}

}
