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
				 * 直接調用run()方法
				 * 系統會把線程對象直接當成普通對象,把run()方法當成普通方法
				 * 所以下面兩行代碼並不會啟動兩個線程,而是依次執行兩個run()方法
				 */
				new InvokeRun().run();
				new InvokeRun().run();
			}
		}
	}

}
