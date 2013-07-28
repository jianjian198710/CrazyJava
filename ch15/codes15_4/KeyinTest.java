package codes15_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyinTest {
	/**
	 * Java使用System.in代表標準輸入,即鍵盤輸入,這個標準輸入流是InputStream類的實例
	 */
	public static void main(String[] args) {
		try(InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr)){
			String s = null;
			while((s=br.readLine())!=null){
				System.out.println(s);
				if(s.equals("exit")){
					System.exit(1);
				}
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

}
