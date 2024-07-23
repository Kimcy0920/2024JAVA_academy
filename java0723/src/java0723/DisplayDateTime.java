package java0723;

import java.time.LocalTime;

import thread.Th1;

public class DisplayDateTime {

	public static void main(String[] args) {
		Thread thread = new Thread(new Th1());
		thread.start();
		
		
		for(int i=0; i<10; i++) {
			try {
				LocalTime localTime = LocalTime.now();
				System.out.printf("%d : %d : %d\n", localTime.getHour(), localTime.getMinute(), localTime.getSecond());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
