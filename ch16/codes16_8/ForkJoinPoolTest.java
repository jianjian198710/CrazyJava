package codes16_8;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;
/*
 * (1)ForkJoinPool��֧�֌�һ���΄ղ�ֳɶ���"С�΄�"�K��Ӌ��,ForkJoinPool��ExecutorService�Č��F�,�ЃɷN���췽ʽ
 *     (a)ForkJoinPool(int Parallelism):����һ������Parallelism���K�о��̵�ForkJoinPool
 *     (b)ForkJoinPool():��Runtime().availableProcessors()�����ķ���ֵ����Parallelism�����턓��ForkJoinPool
 * (2)�{��ForkJoinPool��submit(ForkJoinTask task)��invoke(ForkJoinTask task)������΄�
 * (3)ForkJoinTask��һ�������,���Ѓɂ��������RecursiveAction��RecursiveTask,����ǰ�ߴ���]�з���ֵ���΄�,���ߴ����з���ֵ���΄�
 */
public class ForkJoinPoolTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ForkJoinPool pool = new ForkJoinPool();
		//�ύ�ɷֽ���΄�
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
				System.out.println(Thread.currentThread().getName()+" ��iֵ: "+i);
			}
		}else{
			int middle = (start+end)/2;
			PrintTask left = new PrintTask(start,middle);
			PrintTask right = new PrintTask(middle,end);
			//�K�Ј��Ѓɂ�С�΄�
			left.fork();
			right.fork();
		}
	}
	
}
