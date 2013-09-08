package codes18_5;

import java.lang.reflect.Proxy;

public class MyProxyFactory {
	public static Object getProxy(Object target){
		MyInvokationHandler handler = new MyInvokationHandler();
		handler.setTarget(target);
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
	}
}
