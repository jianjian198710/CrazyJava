package codes16_4;
/*
 * ������е�ǰ̨���̶�����,���_���̕��Ԅ�����
 */
public class DaemonThread extends Thread{

	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(this.getName()+" "+i);
		}
	}
	public static void main(String[] args) {
		DaemonThread dt = new DaemonThread();
		//setDaemon(ture)�����start()֮ǰ�{��,��t�����lIllegalThreadStateException
		dt.setDaemon(true);
		dt.start();
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
		//��̎mian���̽Y����,���_����Ҳ�ԄӽY����
	}

}
