package codes15_4;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

public class PushbackTest {
	/**
	 * �yԇ�ƻ�ݔ����,PushbackInputStream,PushbackReader,
	 * �@�ɂ��ƻ�ݔ����������һ���ƻؾ��n�^,���ֹ�/�ַ��ƻص��ƻؾ��n�^,�Ա����}�xȡ
	 * ��Ҫ������void unread(byte[]/char[] buf),void unread(byte[]/char[],int off,int len),void unread(int b)
	 */
	public static void main(String[] args) {
		//���n�^�L��64
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
