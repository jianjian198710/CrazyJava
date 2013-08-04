package codes16_2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/*
 * Callable接口是新增的接口,不是Runnable接口的子接口,所以Callable不能直接作為Thread的target
 * Java 5提供了Future接口來代表Callable接口里Call()方法的返回值,
 * 并為Future提供了一個FutureTask實現類,它實現了Runnable接口,可作為Thread類的target
 * Callable接口有泛型限制,接口里的泛型形參類型與Call()方法返回值類型相同
 */
public class ThirdThread implements Callable<Integer>{
	
	@Override
	public Integer call() throws Exception {
		int i;
		for(i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" 的循環變量i的值: "+i);
		}
		return i;
	}
	
	public static void main(String[] args) {
		ThirdThread rt = new ThirdThread();
		//使用FutureTask來包裝執行體
		FutureTask<Integer> task = new FutureTask<Integer>(rt);
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" 的循環變量i的值: "+i);
			if(i==20){
				//FutureTask類作為Thread的target
				new Thread(task,"有返回值的線程").start();
			}
		}
		try{
			//返回Callable任務里Call()方法的返回值,調用該方法將導致程序阻塞,必須等到子線程結束后才會得到返回值
			System.out.println("子線程的返回值: "+task.get());
		}catch(Exception e){
			e.printStackTrace();
		}
	}



}
