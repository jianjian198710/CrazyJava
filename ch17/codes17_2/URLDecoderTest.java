package codes17_2;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
/*
 * ��URL��ַ���������ŷ�ַ����ַ���ʱ,ϵͳ�Ὣ��Щ����ŷ���ַ���ת����MIME�ַ���,
 * ʹ��URLDecoder��URLEncoder�������ת��
 */
public class URLDecoderTest {

	public static void main(String[] args) throws IOException {
		String keyWord = URLDecoder.decode("%E7%96%AF%E7%8B%82Java", "GBK");
		System.out.println(keyWord);
		String urlstr = URLEncoder.encode("������", "GBK");
		System.out.println(urlstr);

	}

}
