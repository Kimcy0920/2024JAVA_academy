package java0723;

public class Th1 implements Runnable {
// Runnable interface를 구현, run 메서드를 재정의 해야함
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("삐");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
