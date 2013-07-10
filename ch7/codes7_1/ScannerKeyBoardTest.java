package codes7_1;

import java.util.Scanner;

public class ScannerKeyBoardTest {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		sc.useDelimiter("\\s");
		while(sc.hasNext()){
			System.out.println("The input from keyboard is: "+sc.next());
		}
		sc.close();
	}

}
