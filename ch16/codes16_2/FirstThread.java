package codes16_2;

public class FirstThread extends Thread{
	/*
	 * ʹ��extends Thread�턓������
	 */
	private int i;
	@Override
	public void run(){
		for(i=0;i<100;i++){
			System.out.println(getName()+" "+i);
		}
	}
	public static void main(String[] args) {
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==20){
				new FirstThread().start();
				new FirstThread().start();
			}
		}
	}

}

