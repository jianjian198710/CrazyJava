package codes7_5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchesTest {

	public static void main(String[] args) {
		String[] emails = {"jianjian198710@hotmail.com", "51488384@qq.com","???@.com"};
		Pattern p = Pattern.compile("\\S\\w{1,}@\\w+\\.com");
		for(String str : emails){
			Matcher m = p.matcher(str);
			/*
			 * 當匹配的String長與正則表達式 lookingAt()可用於返回String的開頭是否與正則表達式匹配 比如正則是Java 匹配String是Java is easy？ 
			 * lookingAt()返回true
			 * 
			 * reset(str)用於matcher將str排在第一個位置
			 * 
			 * m.group()一定要在匹配過了以後才能夠用 否則報Exception
			 */
			if(m.matches()==true){
				System.out.println(m.group()+" is correct!");
			}else{
				System.out.println(str+" is incorrect!");
			}
		}

	}

}
