package java0729;

public class ThreadEx1 {

	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread(); // 이 코드를 실행하는 스레드 객체 얻기
		System.out.println("프로그램 시작 스레드 이름: " + mainThread.getName()); // 이름 얻기
		
		ThreadA thA = new ThreadA();
		thA.start();
		
		// 익명 객체 생성으로 이름얻기
		Thread threadB = new Thread() { // 익명이지만 스레드 객체여서 this.getName()가능
			@Override
			public void run() {
				for(int i=0; i<2; i++) {
					System.out.println(this.getName() + "가 출력한 내용");
					try {
						Thread.sleep(1000); // 스레드 제어: 스레드 쉬는시간 지정, 쉬는동안 다른 스레드가 실행됨
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		threadB.setName("ThreadB");
		threadB.start();
		
		
		Thread threadC = new Thread(new Runnable() { // Runnable에서는 this 사용 불가능
			@Override
			public void run() {
				for(int i=0; i<2; i++) {
//					System.out.println(this.getName() + "가 출력한 내용"); 스레드 객체가 아니어서 안됨
					System.out.println("ThreadC가 출력한 내용");
				}
			}
		});
//		threadC.setName("ThreadC"); // 이름을 줄 수는 있음
		threadC.start();
	}

}
