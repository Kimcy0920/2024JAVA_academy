package java0716;

public class Point {

	int x, y; // 필드
	
	public Point() { // 2. 부모클래스에도 기본생성자 작성, 에러 사라짐.
		System.out.println("부모 기본생성자 호출"); // a.부모 먼저 호출
	}

	void method1() {
		System.out.println(x + ", " + y);
	}

	public Point(int x, int y) { // 생성자
		super();
		this.x = x;
		this.y = y;
	}

}
