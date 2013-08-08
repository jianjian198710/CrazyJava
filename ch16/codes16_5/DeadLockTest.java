package codes16_5;
/*
 * 導致程序死鎖
 */
public class DeadLockTest implements Runnable{
	A a = new A();
	B b = new B();
	
	public void init(){
		Thread.currentThread().setName("主線程");
		a.foo(b);
		System.out.println("進入了主線程之後");
	}
	@Override
	public void run() {
		Thread.currentThread().setName("副線程");
		b.bar(a);
		System.out.println("進入了副線程之後");
	}
	
	public static void main(String[] args) {
		DeadLockTest d1 = new DeadLockTest();
		new Thread(d1).start();
		d1.init();
	}



}

class A{
	public synchronized void foo(B b){
		System.out.println("當前線程名: "+Thread.currentThread().getName()+" 進入了A實例的foo方法");
		try{
			Thread.sleep(200);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("當前線程名: "+Thread.currentThread().getName()+" 企圖調用B實例的last方法");
		b.last();
	}
	
	public synchronized void last(){
		System.out.println("進入了A類的last方法內部");
	}
}

class B{
	public synchronized void bar(A a){
		System.out.println("當前線程名: "+Thread.currentThread().getName()+" 進入了B實例的bar方法");
		try{
			Thread.sleep(200);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("當前線程名: "+Thread.currentThread().getName()+" 企圖調用A實例的last方法");
		a.last();
	}
	
	public synchronized void last(){
		System.out.println("進入了B類的last方法內部");
	}
}
