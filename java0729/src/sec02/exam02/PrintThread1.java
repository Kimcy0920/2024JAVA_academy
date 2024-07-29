package sec02.exam02;

public class PrintThread1 extends Thread {

	private boolean stop; // 기본값 false
	
	public void setStop(boolean stop) { // private는 setStop으로 끝내야함
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop) { // true 무한반복
			System.out.println("실행 중");
		}
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
	
}
