package codes16_2;

public class SecondThread implements Runnable{
	/*
	 * ����Runnable�ӿڵķ�ʽ�����Ķ������̿��Թ�����Č�������private int i;
	 * Runnable����H�H����Thread�����Target,�����H�ľ��̌�����Ȼ��Thread����,
	 * ֻ��ԓThread����ؓ؟������Target��run()����
	 */
	private int i;
	@Override
	public void run() {
		for(i=0;i<100;i++){
			//ͨ�^���FRunnable�ӿځ�@�î�ǰ���̌���,���ʹ��Thread.currentThread()����
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	public static void main(String[] args) {
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==20){
				SecondThread st = new SecondThread();
				//�ɂ����̹���private int i׃��
				new Thread(st,"�¾���1").start();
				new Thread(st,"�¾���2").start();
			}
		}
	}



}
