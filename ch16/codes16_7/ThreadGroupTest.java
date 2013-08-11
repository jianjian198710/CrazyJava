package codes16_7;
/*
 * (1)Javaʹ��ThreadGroup���ʾ���̽M,�Ñ􄓽������о��̶����ָ�����̽M,�������]���@ʾָ�����̌���Ă�����,�tԓ���̌��Ĭ�J���̽M
 * (2)Ĭ�J��r��,�Ӿ��̺̈́������ľ���̎�ͬһ�����̽M��
 * (3)�����\���в��ܸ�׃���ľ��̽M
 * Thread��ṩ�����ׂ����������O���½��ľ��̌���Ă����̽M
 *     (a)Thread(ThreadGroup group,Runnable target)
 *     (b)Thread(ThreadGroup group,Runnable target,String name)
 *     (c)Thread(ThreadGroup group,String name)
 * ThreadGroup�ṩ���º��η����턓������
 *     (a)ThreadGroup(String name)
 *     (b)ThreadGroup(ThreadGroup parent,String name)
 * ThreadGroup�ṩ���ׂ����õķ���������������̽M������о���
 * 	    int activeCount()���ؾ��̽M�л�Ӿ��̵Ĕ�Ŀ
 * 	    interrupt()�K�˾��̽M�е����о���
 *      isDeamon()�Д�ԓ���̽M�Ƿ�����_����
 *      setDaemon(boolean daemon)
 *      setMaxPriority(int pri)
 */
public class ThreadGroupTest {
	
	
	public static void main(String[] args) {
		//�@ȡ���������ڵľ��̽M,�@�����о���Ĭ�J�ľ��̽M
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		System.out.println("�����̽M������: "+mainGroup.getName());
		System.out.println("�����̽M�Ƿ�����_���̽M: "+mainGroup.isDaemon());
		new Thread("�����̽M�ľ���").start();
		//�������̽Mtg
		ThreadGroup tg = new ThreadGroup("�¾��̽M");
		tg.setDaemon(true);
		System.out.println("tg���̽M�Ƿ������_���̽M: "+tg.isDaemon());
		//�ھ��̽Mtg�Є����¾���
		MyThread tt = new MyThread(tg,"tg�M�ľ��̼�");
		tt.start();
		new MyThread(tg,"tg�M�ľ�����");
	}

}

class MyThread extends Thread{
	public MyThread(String name){
		super(name);
	}
	public MyThread(ThreadGroup group,String name){
		super(group,name);
	}
	public void run(){
		for(int i=0;i<20;i++){
			System.out.println(getName()+" ���̵�i׃��"+i);
		}
	}
}