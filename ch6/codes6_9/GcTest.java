package codes6_9;
/*
 * (1)GCֻؓ؟���նуȴ��еČ���,���������κ������YԴ,����o�����_����GC
 * (2)�����ڃȴ��������N��B:���_,�ɻ֏�,�����_
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
