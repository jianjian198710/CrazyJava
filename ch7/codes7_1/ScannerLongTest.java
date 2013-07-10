package codes7_1;

import java.util.Scanner;

public class ScannerLongTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLong()){
			System.out.println("The input from keyborad is: "+sc.nextLong());
		}
		sc.close();
	}
		
}
