package codes15_4;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

public class PushbackTest {
	/**
	 * 測試推回輸入流,PushbackInputStream,PushbackReader,
	 * 這兩個推回輸入流都帶有一個推回緩衝區,將字節/字符推回到推回緩衝區,以便重複讀取
	 * 主要方法為void unread(byte[]/char[] buf),void unread(byte[]/char[],int off,int len),void unread(int b)
	 */
	public static void main(String[] args) {
		//緩衝區長度64
		try(PushbackReader pr = new PushbackReader(new FileReader("ch15/codes15_4/PushbackTest.java"),64)){
			char[] chs = new char[32];
			String lastContent = "";
			int hasRead = 0;
			while((hasRead = pr.read(chs))>0){
				String content = new String(chs,0,hasRead);
				int targetIndex = 0;
				if((targetIndex = (lastContent+content).indexOf("new PushbackReader"))>0){
					pr.unread((lastContent+content).toCharArray());
					if(targetIndex>32){
						chs = new char[targetIndex];
					}
					pr.read(chs, 0, targetIndex);
					System.out.println(new String(chs,0,targetIndex));
					System.exit(0);
				}else{
					System.out.println(lastContent);
					lastContent = content;
				}
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

}
