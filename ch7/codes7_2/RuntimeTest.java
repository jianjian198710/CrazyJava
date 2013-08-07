package codes7_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Runtime����Java������\�Еr�h��,ÿ��Java������һ���c֮������Runtime����,ͨ�^getRuntime()�����õ�
 */
public class RuntimeTest {

	public static void main(String[] args) throws IOException {
		Runtime rt = Runtime.getRuntime();
		System.out.println("The number of Processor: "+rt.availableProcessors());
		System.out.println("The free Memory: "+rt.freeMemory());
		System.out.println("The total Memory: "+rt.totalMemory());
		System.out.println("The Max Memory can be used: "+rt.maxMemory());
		
		//��ֱ��������ǰOS�Ľ���
		rt.exec("calc.exe");
		
		//��dos�����І���Java����,�K������ݔ����Console
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
