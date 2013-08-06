package codes16_4;

import java.util.Date;

public class SleepTest {
	/**
	 * static void sleep(long millis)受到系統計時器和線程調度器的精度與準確度的影響
	 * sleep和yield的方法區別
	 * (1)sleep()方法暫停當前線程后,不會理會其他線程的優先級
	 * (2)sleep()方法會將線程轉入阻塞狀態,直到經過阻塞時間才會轉入就緒狀態
	 * (3)sleep()方法聲明拋出了InterruptedException異常
	 */
	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<100;i++){
			System.out.println("當前時間:"+new Date());
			Thread.sleep(1000);
		}
	}

}
