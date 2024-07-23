package thread;

public class Ex1 {

	public static void main(String[] args) { // 메인 스레드
		Thread thread = new Thread(new Th1()); // 작업 스레드 생성
		thread.start(); // 작업 스레드 실행
		
//		for(int i=0; i<5; i++) {
//			System.out.println("삐");
//		}
		
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500); // 1000 = 1초, 스레드 속도 조절
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
