package codes7_5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartEnd {

	public static void main(String[] args) {
		String s ="Java is very easy?";
		Matcher m = Pattern.compile("\\w+").matcher(s);
		while(m.find()){
			/*
			 * start()������һ����Patternƥ����ַ�����Ŀ���ַ����еĿ�ʼλ��
			 * end()������һ����Patternƥ����ַ�����Ŀ���ַ����еĽ���λ��+1
			 */
			System.out.println(m.group()+" Start: "+m.start()+" End: "+m.end());
		}
	}

}
