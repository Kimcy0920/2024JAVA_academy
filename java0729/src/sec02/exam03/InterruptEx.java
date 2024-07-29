package sec02.exam03;

public class InterruptEx {

	public static void main(String[] args) {
		PrintThread2 printThread2 = new PrintThread2();
		
		printThread2.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
		printThread2.interrupt(); // interruptedException을 발생시켜 스레드 종료
	}

}
