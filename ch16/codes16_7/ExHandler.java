package codes16_7;
/*
 * (1)������̈����^���В�����һ��δ̎��Į���,JVM�ڽY��ԓ����֮ǰ���ԄӲ�ֵ�Ƿ��Ќ�����Thread.UncaughtExceptionHandler����
 *    ����ҵ�ԓ����,�t���{������uncaughtException(Thread t, Throwable e)������̎��ԓ����
 * (2)Thread.UncaughtExceptionHandler��Thread�һ���o�B�Ȳ��ӿ�
 * (3)Thread�ṩ�˃ɂ�������O�î���̎����
 *    (a)static setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler eh)
 *    (b)setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler eh)
 *  
 */
public class ExHandler {
	
	public static void main(String[] args) {
		Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
		int a =5/0;
		System.out.println("������������!");
	}
}

class MyExHandler implements Thread.UncaughtExceptionHandler{
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t+" �̳߳������쳣:" +e);
	}
}