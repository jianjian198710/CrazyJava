package codes10_2;

import java.io.FileInputStream;
import java.io.IOException;

public class FinallyTest {

	/**
	 * 測試Finally塊,除非在try或者catch塊中調用了System.exit(1)或者Runtime.getRuntime().exit(1)退出JVM,否則Finally塊都會被執行
	 */
	public static void main(String[] args) {
		FileInputStream fls = null;
		try{
			fls = new FileInputStream("a.txt");
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
			//退出JVM,Finally块不会执行
//			Runtime.getRuntime().exit(1);
			return;
		}finally{
			if(fls!=null){
				try{
					fls.close();
				}catch(IOException ioe){
					ioe.printStackTrace();
				}
			}
			System.out.println("Execute Finally Part!");
		}
	}

}
