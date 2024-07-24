package singleton;

public class Singleton {
	private static Singleton singleton = new Singleton();
	// 정적 변수 = 객체 생성을 안해도 사용가능하나 객체를 생성하고
	// private를 써서 접근을 못하게 막음
	
	private Singleton() { // private로 생성자를 만들어 접근할 수 없게 함
		System.out.println("싱글톤 객체 생성");
	}
	
	// getInstance()를 사용해 접근가능, 유일한 접근수단
	public static Singleton getInstance() {
		return singleton;
	}
}
