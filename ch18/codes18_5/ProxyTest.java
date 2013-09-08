package codes18_5;
/*
 * Proxy�ṩ������������������̬������Ͷ�̬����ʵ��
 * (1)static Class<?> getProxyClass(ClassLoader loader,Class<?>...interfaces)
 * 	    ����һ����̬����������Ӧ��Class����,�ô����ཫʵ��interfaces��ָ���Ķ���ӿ�
 * (2)static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
 * 	    ֱ�Ӵ���һ����̬�������,�ô�������ʵ����ʵ����interfacesָ����ϵ�нӿ�,ִ�д�������ÿ�������Ƕ����滻ִ��InvocationHandler�����invoke����
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) {
		InvocationHandler handler = new MyInvokationHandler();
		Person p = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, handler);
		p.walk();
		p.sayHello("Java");
	}

}

interface Person{
	void walk();
	void sayHello(String name);
}

class MyInvokationHandler2 implements InvocationHandler{
	public Object invoke(Object proxy, Method method, Object[] args){
		System.out.println("-----����ִ�еķ���:"+method);
		if(args!=null){
			System.out.println("������ִ�и÷���ʱ����Ĳ���Ϊ: ");
			for(Object val:args){
				System.out.println(val);
			}
		}else{
			System.out.println("���ø÷���û��ʵ��!");
		}
		return null;
	}
}
