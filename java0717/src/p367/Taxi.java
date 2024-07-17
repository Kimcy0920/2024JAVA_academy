package p367;

public class Taxi implements Vehicle {
//public class Taxi extends Vehicle { // Vehicle에서 상속받은 Taxi 클래스

	@Override // run 메소드를 재정의함
	public void run() {
		System.out.println("택시가 달립니다.");
	}
	
}
