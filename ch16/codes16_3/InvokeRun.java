package codes16_3;

public class InvokeRun extends Thread{

	private int i;
	@Override
	public void run(){
		for(i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	
	public static void main(String[] args) {
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==20){
				/*
				 * ֱ���{��run()����
				 * ϵ�y���Ѿ��̌���ֱ�Ӯ�����ͨ����,��run()����������ͨ����
				 * ����������д��a�K�������Ӄɂ�����,�������Έ��Ѓɂ�run()����
				 */
				new InvokeRun().run();
				new InvokeRun().run();
			}
		}
	}

}
