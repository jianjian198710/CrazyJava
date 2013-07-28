package codes15_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromProcess {
	/**
	 * Runtime對象的exec()方法產生一個Process對象，
	 * Process類提供了3個方法,用於讓程序和其子進程進行通信
	 * InputStream getErrorStream();獲取子進程錯誤流
	 * InputStream getInputStream();
	 * OutputStream getOutputStream();
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Process p = Runtime.getRuntime().exec("javac");
		try(BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()))){
			String buff = null;
			while((buff=br.readLine())!=null){
				System.out.println(buff);
			}
		}
	}

}
