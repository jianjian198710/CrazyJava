package codes7_5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindGroup {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("\\w+");
		Matcher m = p.matcher("Java is very easy?");
		int i = 0;
		/*每調用一次p的matches()或者find()方法 索引自動會往後走 等到執行while的時候已經是從"very"開始了
		 *其實可以用find(0)開始這樣就可以從頭開始鳥
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
