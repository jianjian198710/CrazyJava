package codes15_8;

import java.io.ObjectStreamException;
import java.io.Serializable;
/*
 * ʹ��Java 5��ǰ��ö�e���,��readResovle()����,
 * ԓ�����ķ���ֵ�������ԭ�����л��Č���,ԭ��Č�����������G��
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
