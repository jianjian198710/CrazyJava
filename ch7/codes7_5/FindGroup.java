package codes7_5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindGroup {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("\\w+");
		Matcher m = p.matcher("Java is very easy?");
		int i = 0;
		/*ÿ�{��һ��p��matches()����find()���� �����Ԅӕ������� �ȵ�����while�ĕr���ѽ��Ǐ�"very"�_ʼ��
		 *�䌍������find(0)�_ʼ�@�ӾͿ��ԏ��^�_ʼ�B
		*/
		System.out.println(m.matches());
		System.out.println(m.find());
		while (m.find()) {
			System.out.println(m.group());
		}
		
		System.out.println(m.matches());
		while (m.find(i)) {
			System.out.println(m.group());
			i++;
		}
	}

}
