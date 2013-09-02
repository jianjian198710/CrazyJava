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
			 * ��ƥ���String�L�c���t���_ʽ lookingAt()����춷���String���_�^�Ƿ��c���t���_ʽƥ�� �������t��Java ƥ��String��Java is easy�� 
			 * lookingAt()����true
			 * 
			 * reset(str)���matcher��str���ڵ�һ��λ��
			 * 
			 * m.group()һ��Ҫ��ƥ���^��������܉��� ��t��Exception
			 */
			if(m.matches()==true){
				System.out.println(m.group()+" is correct!");
			}else{
				System.out.println(str+" is incorrect!");
			}
		}

	}

}
