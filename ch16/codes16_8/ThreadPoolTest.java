package codes16_8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/*
 * (1)Executors���S�a�����̳�,ͨ�^�傀����:
 *    newCachedThreadPool(),newFixedThreadPool(int nThreads),newSingleThreadExecutor()����ExecutorService����
 *    newScheduledThreadPool(int corePoolSize),newSingleThreadScheduledExecutor()����ScheduledExecutorService����
 * (2)ExecutorService�������һ�����̳�,�����Ԉ���Runnable����@Callable����������ľ���,
 *    ScheduleExecutorService��ExecutorService�����,����ָ�����t����еľ���
 * (3)ExecutorService�ṩ����3������
 *    (a)Future<?> submit(Runnable task),Future����Runnable�΄յķ���ֵ,�Y���󷵻�null,
 *       Future��������{��isDone(),isCancelled()��@ȡRunnable����Ĉ��Р�B
 *    (b)<T> Future<T> submit(Runnable task, T result),result�@ʾָ�����̈��нY����ķ���ֵ,���Future������run()�������нY���󷵻�result
 *    (c)<T> Future<T> submit(Callable<T> task),Future����Callable����call()�����ķ���ֵ
 */
public class ThreadPoolTest {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService pool = Executors.newFixedThreadPool(6);
		MyThread target1 = new MyThread();
		Future<?> future = pool.submit(target1);
		pool.submit(target1);
		Thread.sleep(200);
		System.out.println(future.isDone());
		//�{��shutdown()������ľ��̳ز��ٽ������΄�,��������ǰ���������ύ�ľ��̈������
		pool.shutdown();
	}

}

class MyThread implements Runnable{
	@Override
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" ��iֵΪ:"+i);
		}
	}
}
