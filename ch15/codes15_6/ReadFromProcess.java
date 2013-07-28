package codes15_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromProcess {
	/**
	 * Runtime�����exec()�����a��һ��Process����
	 * Process��ṩ��3������,���׌����������M���M��ͨ��
	 * InputStream getErrorStream();�@ȡ���M���e�`��
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
