package codes16_4;

import java.util.Date;

public class SleepTest {
	/**
	 * static void sleep(long millis)�ܵ�ϵ�yӋ�r���;����{�����ľ����c�ʴ_�ȵ�Ӱ�
	 * sleep��yield�ķ����^�e
	 * (1)sleep()������ͣ��ǰ���̺�,��������������̵ă��ȼ�
	 * (2)sleep()�������������D��������B,ֱ�����^�����r�g�ŕ��D��;w��B
	 * (3)sleep()������������InterruptedException����
	 */
	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<100;i++){
			System.out.println("��ǰ�r�g:"+new Date());
			Thread.sleep(1000);
		}
	}

}
