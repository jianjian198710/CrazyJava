package codes18_4;

import java.lang.reflect.Constructor;

public class CreateJFrame {

	public static void main(String[] args) throws Exception {
		Class<?> jframeClazz = Class.forName("javax.swing.JFrame");
		Constructor<?> ctor = jframeClazz.getConstructor(String.class);
		Object obj = ctor.newInstance("���Դ���");
		System.out.println(obj);
	}

}
