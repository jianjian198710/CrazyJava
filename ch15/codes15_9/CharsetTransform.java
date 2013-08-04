package codes15_9;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharsetTransform {
	/**
	 * 測試Charset的編解碼器
	 */
	public static void main(String[] args) throws CharacterCodingException {
		Charset cn = Charset.forName("GBK");
		CharsetEncoder cnEncoder = cn.newEncoder();
		CharsetDecoder cnDecoder = cn.newDecoder();
		CharBuffer cbuff = CharBuffer.allocate(8);
		cbuff.put('草');
		cbuff.put('尼');
		cbuff.put('碼');
		cbuff.flip();
		ByteBuffer bbuff = cnEncoder.encode(cbuff);
		for(int i=0;i<bbuff.capacity();i++){
			System.out.println(bbuff.get(i)+"");
		}
		System.out.println(cnDecoder.decode(bbuff));
		cbuff.clear();
		//直接調用Charset的encode()和decode()方法
		String s = "Fuck!";
		ByteBuffer buff = cn.encode(s);
		System.out.println(buff);
		System.out.println(cn.decode(buff));
	}

}
