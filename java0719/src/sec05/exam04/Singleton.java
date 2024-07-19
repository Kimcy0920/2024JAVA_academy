package sec05.exam04;

public class Singleton {
	private static Singleton singleton = new Singleton(); // 클래스 내부에서 객체 생성
	
	private Singleton() {} // 클래스 내부에서만 사용가능한 생성자
	
	static Singleton getInstance() { // 외부에서 호출할 수 있는 유일한 방법
		return singleton;
	}
}
