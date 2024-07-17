package p367;

public class Bus implements Vehicle { 
//public class Bus extends Vehicle { // Vehicle에서 상속받은 Bus 클래스
	
	@Override // run 메소드를 재정의함
	public void run() {
		System.out.println("버스가 달립니다.");
	}
}
