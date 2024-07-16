package java0716;

public class Calculator { // 필드가 없는 상태
	int x, y; // 필드
	
	int plus() { // 필드값이 생겨 매개변수가 없어도 됨.
//	int plus(int x, int y) {
//		int result = x + y;
//		return result; // int타입
		return this.x + this.y; // 클래스 내에 있는 x, y값
		// 같음
	}
	
		double avg() { // 필드값이 생겨 매개변수가 없어도 됨.
//		double avg(int x, int y) {
//		double sum = x + y; = double sum = plus(x, y);
		
//		double sum = plus(x, y);
//		double result = sum / 2; // result 값을 return 0.0에 대입
//		return result; // double타입
//		return plus(x, y) / 2.0;
		return this.plus() / 2.0; // this.() 클래스 내에 있는 plus
		// 같음
	}
	
	void execute() { // 필드값이 생겨 매개변수가 없어도 됨.
		double result = avg();
//		double result = avg(7, 10);
//		println("실행결과: " + result); // this.() 클래스 내에 있는 println
		this.println("실행결과: " + result);
	}
	
	void println(String msg) {
		System.out.println(msg);
	}

	@Override
	public String toString() {
		return "Calculator [x = " + x + ", y = " + y + "]";
	}

}
