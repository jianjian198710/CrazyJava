package codes15_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class WriteToProcess {
	/**
	 * ²Î¿¼WriteToProcess
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("H:/Developer/Java work space/CrazyJava/bin");
		Process p = Runtime.getRuntime().exec("java codes15_6.ReadStandard aaa",null,file);
		try(PrintStream ps = new PrintStream(p.getOutputStream())){
			ps.println("ÆÕÍ¨×Ö·û´®");
			ps.println("new WriteToProcess()");
		}
	}
}

class ReadStandard{
	public static void main(String[] args) throws IOException{
		try(Scanner sc = new Scanner(System.in);
			PrintStream ps = new PrintStream(new FileOutputStream("out2.txt"))){
			sc.useDelimiter("\n");
			while(sc.hasNext()){
				ps.println(sc.next());
			}
			ps.println(args[0]);
		}
	}
}
