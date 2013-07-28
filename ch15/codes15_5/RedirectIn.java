package codes15_5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class RedirectIn {
	/**
	 * …¢¿¼RedirectOut.java
	 */
	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("ch15/codes15_5/RedirectIn.java")){
			System.setIn(fis);
			Scanner sc = new Scanner(System.in);
			sc.useDelimiter("\n");
			while(sc.hasNext()){
				System.out.println(sc.next());
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

}
