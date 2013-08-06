package codes16_4;

public class PriorityTest extends Thread{
	
	public PriorityTest(String name){
		super(name);
	}
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(getName()+",其優先級是: "+getPriority()+",循環變量的值為:"+i);
		}
	}
	public static void main(String[] args) {
		//改變主線程的優先級,由main線程創建的子線程的優先級默認都是6
		Thread.currentThread().setPriority(6);
		for(int i=0;i<30;i++){
			if(i==10){
				PriorityTest low = new PriorityTest("低級");
				low.start();
				System.out.println("創建之初的優先級:"+low.getPriority());
				low.setPriority(MIN_PRIORITY);
			}
			if(i==20){
				PriorityTest high = new PriorityTest("高級");
				high.start();
				System.out.println("創建之初的優先級:"+high.getPriority());
				high.setPriority(MAX_PRIORITY);
			}
		}
	}

}
