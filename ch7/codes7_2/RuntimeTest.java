package codes7_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Runtime代表Java程序的運行時環境,每個Java程序都有一個與之對應的Runtime實例,通過getRuntime()方法得到
 */
public class RuntimeTest {

	public static void main(String[] args) throws IOException {
		Runtime rt = Runtime.getRuntime();
		System.out.println("The number of Processor: "+rt.availableProcessors());
		System.out.println("The free Memory: "+rt.freeMemory());
		System.out.println("The total Memory: "+rt.totalMemory());
		System.out.println("The Max Memory can be used: "+rt.maxMemory());
		
		//可直接启动当前OS的进程
		rt.exec("calc.exe");
		
		//在dos命令中啟動Java程序,並將程序輸出到Console
		File file = new File("H:/Developer/Java work space/CrazyJava/bin");
		try(InputStreamReader isr = new InputStreamReader(rt.exec("java codes7_1.ArgsTest Hello",null,file).getInputStream());
			BufferedReader br = new BufferedReader(isr)){
			String s = null;
			while((s=br.readLine())!=null){
				System.out.println(s);
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
}
