package codes6_9;

public class FinalizeTest2 {

	private static FinalizeTest2 ft = null;
	
	public void info(){
		System.out.println(this.getClass().getName()+" involk the info method!");
	}
	
	public static void main(String[] args) {
		new FinalizeTest2();
		Runtime.getRuntime().gc();
		//System和Runtime類都提供了runFinalization()方法,可以強制GC調用系統中可恢復對象的finalize方法
		Runtime.getRuntime().runFinalization();
		ft.info();
	}
	
	public void finalize(){
		ft = this;
	}

}
