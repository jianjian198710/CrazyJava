package codes17_2;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
/*
 * 当URL地址里包含非西欧字符的字符串时,系统会将这些非西欧的字符串转换成MIME字符串,
 * 使用URLDecoder和URLEncoder类来完成转换
 */
public class URLDecoderTest {

	public static void main(String[] args) throws IOException {
		String keyWord = URLDecoder.decode("%E7%96%AF%E7%8B%82Java", "GBK");
		System.out.println(keyWord);
		String urlstr = URLEncoder.encode("草泥马", "GBK");
		System.out.println(urlstr);

	}

}
