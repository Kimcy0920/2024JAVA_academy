package sec02.exam02;

public class StopFlagEx {

	public static void main(String[] args) {
		PrintThread1 printThread = new PrintThread1();
		
		printThread.start();

		try {
			Thread.sleep(1000); // 1초 후 스레드 종료
		} catch (InterruptedException e) {
			
		}
		printThread.setStop(true);
	}

}
