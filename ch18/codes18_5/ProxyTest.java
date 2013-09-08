package codes18_5;
/*
 * Proxy提供了两个方法来创建动态代理类和动态代理实例
 * (1)static Class<?> getProxyClass(ClassLoader loader,Class<?>...interfaces)
 * 	    创建一个动态代理类所对应的Class对象,该代理类将实现interfaces所指定的多个接口
 * (2)static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
 * 	    直接创建一个动态代理对象,该代理对象的实现类实现了interfaces指定的系列接口,执行代理对象的每个方法是都会替换执行InvocationHandler对象的invoke方法
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
		System.out.println("-----正在执行的方法:"+method);
		if(args!=null){
			System.out.println("下面试执行该方法时传入的参数为: ");
			for(Object val:args){
				System.out.println(val);
			}
		}else{
			System.out.println("调用该方法没有实参!");
		}
		return null;
	}
}
