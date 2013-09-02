package codes7_5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartEnd {

	public static void main(String[] args) {
		String s ="Java is very easy?";
		Matcher m = Pattern.compile("\\w+").matcher(s);
		while(m.find()){
			/*
			 * start()返回上一次与Pattern匹配的字符串在目标字符串中的开始位置
			 * end()返回上一次与Pattern匹配的字符串在目标字符串中的结束位置+1
			 */
			System.out.println(m.group()+" Start: "+m.start()+" End: "+m.end());
		}
	}

}
