package codes16_4;

public class PriorityTest extends Thread{
	
	public PriorityTest(String name){
		super(name);
	}
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(getName()+",�䃞�ȼ���: "+getPriority()+",ѭ�h׃����ֵ��:"+i);
		}
	}
	public static void main(String[] args) {
		//��׃�����̵ă��ȼ�,��main���̄������Ӿ��̵ă��ȼ�Ĭ�J����6
		Thread.currentThread().setPriority(6);
		for(int i=0;i<30;i++){
			if(i==10){
				PriorityTest low = new PriorityTest("�ͼ�");
				low.start();
				System.out.println("����֮���ă��ȼ�:"+low.getPriority());
				low.setPriority(MIN_PRIORITY);
			}
			if(i==20){
				PriorityTest high = new PriorityTest("�߼�");
				high.start();
				System.out.println("����֮���ă��ȼ�:"+high.getPriority());
				high.setPriority(MAX_PRIORITY);
			}
		}
	}

}
