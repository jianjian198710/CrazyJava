package codes15_8;

import java.io.ObjectStreamException;
import java.io.Serializable;
/*
 * 使用Java 5以前的枚舉類寫法,寫readResovle()方法,
 * 該方法的返回值將會替代原來反序列化的對象,原來的對象會被立即丟棄
 */
public class Orientation2 implements Serializable{
	private static final long serialVersionUID = 8845084168326516306L;
	public static final Orientation2 HORIZONTAL = new Orientation2(1);
	public static final Orientation2 VERTICAL = new Orientation2(2);
	private int value;
	private Orientation2(int value)
	{
		this.value = value;
	}
	
	private Object readResolve()throws ObjectStreamException
	{
		if (value == 1)
		{
			return HORIZONTAL;
		}
		if (value == 2)
		{
			return VERTICAL;
		}
		return null;
	}
}
