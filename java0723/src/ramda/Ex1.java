package ramda;

public class Ex1 {

	public static void main(String[] args) { // 메인 스레드
		Thread th1 = new Thread(()->{ // ()-> 람다식
		// 스레드, 인터페이스, 오버라이드 생략함
			// 익명의 구현 객체를 통해서 적용시킴
			for(int i=0; i<5; i++) {
				System.out.println("삐");
				try {
					Thread.sleep(500); // 1000 = 1초, 스레드 속도 조절
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		th1.start();
		
//		Thread thread = new Thread(new Runnable() { // 익명 객체 생성
//
//			@Override
//			public void run() {
//				for(int i=0; i<5; i++) {
//					System.out.println("삐");
//					try {
//						Thread.sleep(500); // 1000 = 1초, 스레드 속도 조절
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}				
//				
//			}
//			
//		});
//		thread.start(); // 작업 스레드 실행
		

		
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
