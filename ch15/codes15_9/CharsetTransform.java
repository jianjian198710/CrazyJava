package codes15_9;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharsetTransform {
	/**
	 * �yԇCharset�ľ���a��
	 */
	public static void main(String[] args) throws CharacterCodingException {
		Charset cn = Charset.forName("GBK");
		CharsetEncoder cnEncoder = cn.newEncoder();
		CharsetDecoder cnDecoder = cn.newDecoder();
		CharBuffer cbuff = CharBuffer.allocate(8);
		cbuff.put('��');
		cbuff.put('��');
		cbuff.put('�a');
		cbuff.flip();
		ByteBuffer bbuff = cnEncoder.encode(cbuff);
		for(int i=0;i<bbuff.capacity();i++){
			System.out.println(bbuff.get(i)+"");
		}
		System.out.println(cnDecoder.decode(bbuff));
		cbuff.clear();
		//ֱ���{��Charset��encode()��decode()����
		String s = "Fuck!";
		ByteBuffer buff = cn.encode(s);
		System.out.println(buff);
		System.out.println(cn.decode(buff));
	}

}
