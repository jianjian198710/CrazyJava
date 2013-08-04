package codes16_2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/*
 * Callable�ӿ��������Ľӿ�,����Runnable�ӿڵ��ӽӿ�,����Callable����ֱ������Thread��target
 * Java 5�ṩ��Future�ӿځ����Callable�ӿ���Call()�����ķ���ֵ,
 * ����Future�ṩ��һ��FutureTask���F�,�����F��Runnable�ӿ�,������Thread�target
 * Callable�ӿ��з�������,�ӿ���ķ����΅�����cCall()��������ֵ�����ͬ
 */
public class ThirdThread implements Callable<Integer>{
	
	@Override
	public Integer call() throws Exception {
		int i;
		for(i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" ��ѭ�h׃��i��ֵ: "+i);
		}
		return i;
	}
	
	public static void main(String[] args) {
		ThirdThread rt = new ThirdThread();
		//ʹ��FutureTask����b�����w
		FutureTask<Integer> task = new FutureTask<Integer>(rt);
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" ��ѭ�h׃��i��ֵ: "+i);
			if(i==20){
				//FutureTask�����Thread��target
				new Thread(task,"�з���ֵ�ľ���").start();
			}
		}
		try{
			//����Callable�΄���Call()�����ķ���ֵ,�{��ԓ���������³�������,��횵ȵ��Ӿ��̽Y����ŕ��õ�����ֵ
			System.out.println("�Ӿ��̵ķ���ֵ: "+task.get());
		}catch(Exception e){
			e.printStackTrace();
		}
	}



}
