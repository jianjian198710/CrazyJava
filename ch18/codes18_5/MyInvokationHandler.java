package codes18_5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvokationHandler implements InvocationHandler{
	//��Ҫ������Ķ���
	private Object target;
	public void setTarget(Object target){
		this.target = target;
	}
	@Override
	//ִ�ж�̬�����������з���ʱ,���ᱻ�滻��ִ�����µ�invoke����
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		DogUtil du = new DogUtil();
		//ִ��DogUtil�����е�method1���� ����AOP�ķ�������ǰ�Ļص�����
		du.method1();
		//��target��Ϊ������ִ��method����
		Object result = method.invoke(target, args);
		//ִ��DogUtil�����е�method2���� ����AOP�ķ������ú�Ļص�����
		du.method2();
		return result;
	}
	
}
