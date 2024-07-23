package thread2;

public class Ex1 {

	public static void main(String[] args) {
//		Thread thread = new Thread(new Th1());
		
		Th1 th1 = new Th1(); // 스레드를 상속으로 받은 Th1 객체 생성
		th1.start(); // 작업 스레드 실행
		
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500); // (1000 = 1초) 0.5초 딜레이
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
