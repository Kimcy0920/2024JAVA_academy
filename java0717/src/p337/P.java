package p337;

public class P {
// public final class P { // 상속 불가능
	int x;
//	final int x;
	
	P(int x) { // 생성자
		this.x = x;	
	}
	
//	void method1() {
	final void method1() { // 메소드 사용 불가능
		System.out.println(x);
	}
}
