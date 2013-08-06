package codes16_4;
/*
 * (1)yield()��һ���o�B����,����׌��ǰ�ľ��̕�ͣ,����������ԓ����,ֻ��׌�����M��;w��B.
 * (2)yield()ֻ��׌��ǰ���̕�ͣһ��,��׌ϵ�y�ľ����{���������{��һ��.
 * (3)�п���ĳ�����̈���yield()����,ϵ�y�֌����{����������.
 * (4)��ĳ�������{��yield()֮��,ֻ�Ѓ��ȼ��c��ǰ������ͬ���߸��ߵ�̎춾;w��B�ľ��̲���؛�Ĉ��еęC��
 */
public class YieldTest extends Thread{

	public YieldTest(String name){
		super(name);
	}
	
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(getName()+" "+i);
			if(i==20){
				Thread.yield();
			}
		}
	}
	
	public static void main(String[] args) {
		YieldTest yt1 = new YieldTest("�߼�");
		//yt1.setPriority(MAX_PRIORITY);
		yt1.start();
		YieldTest yt2 = new YieldTest("�ͼ�");
		//yt2.setPriority(MIN_PRIORITY);
		yt2.start();
	}

}
