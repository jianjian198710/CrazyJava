package codes10_2;

import java.io.FileInputStream;
import java.io.IOException;

public class FinallyTest {

	/**
	 * �yԇFinally�K,������try����catch�K���{����System.exit(1)����Runtime.getRuntime().exit(1)�˳�JVM,��tFinally�K����������
	 */
	public static void main(String[] args) {
		FileInputStream fls = null;
		try{
			fls = new FileInputStream("a.txt");
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
			//�˳�JVM,Finally�鲻��ִ��
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
