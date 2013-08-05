package codes16_2;

public class FirstThread extends Thread{
	/*
	 * 使用extends Thread來創建線程
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
			//当i=20时,线程并不一定会立即执行,这种切换由底层平台控制,具有一定的随机性
			if(i==20){
				new FirstThread().start();
				new FirstThread().start();
			}
		}
	}

}

