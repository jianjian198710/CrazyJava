package codes6_9;

public class FinalizeTest {

	private static FinalizeTest ft = null;
	
	public void info(){
		System.out.println(this.getClass().getName()+" involk the info method!");
	}
	
	public static void main(String[] args) throws InterruptedException {
		new FinalizeTest();
		System.gc();
		Thread.sleep(2000);
		ft.info();
	}
	
	public void finalize(){
		ft = this;
	}

}
