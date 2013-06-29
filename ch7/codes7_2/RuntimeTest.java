package codes7_2;

import java.io.IOException;

public class RuntimeTest {

	public static void main(String[] args) throws IOException {
		Runtime rt = Runtime.getRuntime();
		System.out.println("The number of Processor: "+rt.availableProcessors());
		System.out.println("The free Memory: "+rt.freeMemory());
		System.out.println("The total Memory: "+rt.totalMemory());
		System.out.println("The Max Memory can be used: "+rt.maxMemory());
		
		//可直接启动当前OS的进程
		rt.exec("calc.exe");
	}
}
