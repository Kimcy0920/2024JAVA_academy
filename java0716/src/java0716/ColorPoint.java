package java0716;

public class ColorPoint extends Point { // 상속
//	public class ColorPoint extends Point, Point2 { // 다중상속 불가능
	
// ab. Point가 먼저 실행(생성)되고, 상속받는 ColorPoint가 실행(생성) 후 Ex2(메인)이 실행됨.
	
	public ColorPoint() { // 1. 에러 해결위해 기본생성자 작성, 상속관계여서 부모도 기본생성자가 필요
		super(100, 200); // 부모를 뜻함, 생성하는 코드여서 이 코드 위에 아무런 코드도 없어야함
		System.out.println("자식 기본생성자 호출"); // b. 자식 호출
		
		System.out.println(super.x); // 부모 필드를 가져다 씀
//		System.out.println(x); // 부모 필드를 가져다 씀, super 생략 가능
		
		super.method1();
//		method1(); // 부모 필드를 가져다 씀, super 생략 가능
	} 
	
	public ColorPoint(int x, int y) {
		super(x, y); // 이 코드로 Ex2에 line7 에러발생
	}

	@Override
	void method1() {
//		super.method1();
		System.out.println("자식이 오버라이딩"); // 재정의
	}
	
}
