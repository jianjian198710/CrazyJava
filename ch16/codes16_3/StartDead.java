package codes16_3;

public class StartDead extends Thread{
	private int i;
	@Override
	public void run(){
		for(i=0;i<100;i++){
			System.out.println(this.getName()+" "+i);
		}
	}
	public static void main(String[] args) throws InterruptedException {
		StartDead sd = new StartDead();
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==20){
				sd.start();
				System.out.println(sd.isAlive());
			}
			Thread.sleep(1000);
			if(i>20&&!sd.isAlive()){
				System.out.println(sd.isAlive());
				//對已經Dead的線程再執行Start()引發IllegalThreadStateException異常
				sd.start();
			}
		}
	
	}

}
