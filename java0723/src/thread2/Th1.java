package thread2;

public class Th1 extends Thread { // 스레드를 상속으로 받을 수도 있음
// Runnable interface를 구현, run 메서드를 재정의 해야함
	
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("삐");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
