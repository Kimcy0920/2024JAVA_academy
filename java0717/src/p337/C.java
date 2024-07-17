package p337;

public class C extends P {
	// 부모 클래스에 생성자를 만들어서 에러 발생, line3
	
	C(int x) { // 부모클래스처럼 자식클래스도 생성자를 만들어야함, 강제적
		super(x); // super변수 사용
		super.x = 700;
		super.method1();
		// 부모건 자식거
	}
	
	//재정의, 강제적 아님.
//	@Override // 오버라이드는 오류체크용
//	void method1() {
//		
//	}
	
}
