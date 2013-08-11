package codes16_8;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;
/*
 * (1)ForkJoinPool來支持將一個任務拆分成多個"小任務"並行計算,ForkJoinPool是ExecutorService的實現類,有兩種構造方式
 *     (a)ForkJoinPool(int Parallelism):創建一個包含Parallelism個並行線程的ForkJoinPool
 *     (b)ForkJoinPool():以Runtime().availableProcessors()方法的返回值作為Parallelism參數來創建ForkJoinPool
 * (2)調用ForkJoinPool的submit(ForkJoinTask task)或invoke(ForkJoinTask task)來執行任務
 * (3)ForkJoinTask是一個抽象類,它有兩個抽象子類RecursiveAction和RecursiveTask,其中前者代表沒有返回值的任務,後者代表有返回值的任務
 */
public class ForkJoinPoolTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ForkJoinPool pool = new ForkJoinPool();
		//提交可分解的任務
		pool.submit(new PrintTask(0,300));
		pool.awaitTermination(5, TimeUnit.SECONDS);
		pool.shutdown();

	}

}

class PrintTask extends RecursiveAction{
	private static final long serialVersionUID = 3090954116862747581L;
	private static final int THRESHOLD = 50;
	private int start;
	private int end;
	
	public PrintTask(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		if(end-start<THRESHOLD){
			for(int i=start;i<end;i++){
				System.out.println(Thread.currentThread().getName()+" 的i值: "+i);
			}
		}else{
			int middle = (start+end)/2;
			PrintTask left = new PrintTask(start,middle);
			PrintTask right = new PrintTask(middle,end);
			//並行執行兩個小任務
			left.fork();
			right.fork();
		}
	}
	
}
