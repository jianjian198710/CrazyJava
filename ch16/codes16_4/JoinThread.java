package codes16_4;
/*
 * ��ĳ��������������{���������̵�join()�����r,�{�þ��̌�������,
 * ֱ����join()���������join���̈������ֹ
 * join()�����N���d�΄�
 * (1)join()
 * (2)join(long millis):�ȴ���join�ľ��̵ĕr�g���L��millis����
 * (3)join(long millis,int nanos)�ȴ���join�ľ��̵����L�r�g��millis�������nanos��΢��
 */
public class JoinThread extends Thread{

	public JoinThread(String name){
		super(name);
	}
	
	@Override
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(this.getName()+" "+i);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		new JoinThread("���߳�").start();
		for(int i=0;i<100;i++){
			//i=20�׌Ӿ��_�{��jt����
			if(i==20){
				JoinThread jt = new JoinThread("��Join���߳�");
				jt.start();
				jt.join();
			}
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}

}
