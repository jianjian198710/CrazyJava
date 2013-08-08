package codes16_5;
/*
 * ���³������i
 */
public class DeadLockTest implements Runnable{
	A a = new A();
	B b = new B();
	
	public void init(){
		Thread.currentThread().setName("������");
		a.foo(b);
		System.out.println("�M����������֮��");
	}
	@Override
	public void run() {
		Thread.currentThread().setName("������");
		b.bar(a);
		System.out.println("�M���˸�����֮��");
	}
	
	public static void main(String[] args) {
		DeadLockTest d1 = new DeadLockTest();
		new Thread(d1).start();
		d1.init();
	}



}

class A{
	public synchronized void foo(B b){
		System.out.println("��ǰ������: "+Thread.currentThread().getName()+" �M����A������foo����");
		try{
			Thread.sleep(200);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("��ǰ������: "+Thread.currentThread().getName()+" ��D�{��B������last����");
		b.last();
	}
	
	public synchronized void last(){
		System.out.println("�M����A�last�����Ȳ�");
	}
}

class B{
	public synchronized void bar(A a){
		System.out.println("��ǰ������: "+Thread.currentThread().getName()+" �M����B������bar����");
		try{
			Thread.sleep(200);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("��ǰ������: "+Thread.currentThread().getName()+" ��D�{��A������last����");
		a.last();
	}
	
	public synchronized void last(){
		System.out.println("�M����B�last�����Ȳ�");
	}
}
