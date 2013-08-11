package codes16_7;
/*
 * (1)如果線程執行過程中拋出了一個未處理的異常,JVM在結束該線程之前會自動差值是否有對應的Thread.UncaughtExceptionHandler對象
 *    如果找到該對象,則會調用它的uncaughtException(Thread t, Throwable e)方法來處理該異常
 * (2)Thread.UncaughtExceptionHandler是Thread類的一個靜態內部接口
 * (3)Thread提供了兩個方法類設置異常處理器
 *    (a)static setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler eh)
 *    (b)setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler eh)
 *  
 */
public class ExHandler {
	
	public static void main(String[] args) {
		Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
		int a =5/0;
		System.out.println("程序正常结束!");
	}
}

class MyExHandler implements Thread.UncaughtExceptionHandler{
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t+" 线程出现了异常:" +e);
	}
}