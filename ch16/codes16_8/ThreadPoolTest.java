package codes16_8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/*
 * (1)Executors工廠類來產生線程池,通過五個方法:
 *    newCachedThreadPool(),newFixedThreadPool(int nThreads),newSingleThreadExecutor()返回ExecutorService對象
 *    newScheduledThreadPool(int corePoolSize),newSingleThreadScheduledExecutor()返回ScheduledExecutorService對象
 * (2)ExecutorService對象代表一個線程池,它可以執行Runnable對象獲Callable對象所代表的線程,
 *    ScheduleExecutorService是ExecutorService的子類,可以指定延遲后執行的線程
 * (3)ExecutorService提供如下3個方法
 *    (a)Future<?> submit(Runnable task),Future代表Runnable任務的返回值,結束后返回null,
 *       Future對象可以調用isDone(),isCancelled()來獲取Runnable對象的執行狀態
 *    (b)<T> Future<T> submit(Runnable task, T result),result顯示指定線程執行結束后的返回值,因此Future對象將在run()方法執行結束后返回result
 *    (c)<T> Future<T> submit(Callable<T> task),Future代表Callable對象call()方法的返回值
 */
public class ThreadPoolTest {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService pool = Executors.newFixedThreadPool(6);
		MyThread target1 = new MyThread();
		Future<?> future = pool.submit(target1);
		pool.submit(target1);
		Thread.sleep(200);
		System.out.println(future.isDone());
		//調用shutdown()方法后的線程池不再接收新任務,但會將以前的所有已提交的線程執行完成
		pool.shutdown();
	}

}

class MyThread implements Runnable{
	@Override
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" 的i值为:"+i);
		}
	}
}
