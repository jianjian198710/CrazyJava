package codes6_9;
/*
 * (1)GC只負責回收堆內存中的對象,不會回收任何物理資源,程序無法精確控制GC
 * (2)對象在內存中有三種狀態:可達,可恢復,不可達
 */
public class GcTest {

	public static void main(String[] args) {
		for(int i=0;i<4;i++){
			new GcTest();
			Runtime.getRuntime().gc();
		}

	}
	
	public void finalize(){
		System.out.println("The system is clearing the resource!");
	}

}
