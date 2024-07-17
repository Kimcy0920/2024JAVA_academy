package p357;

// 한 파일에 public이 붙은 클래스가 두 개 이상 존재할 수 없음

class A {}

class B extends A {
	
}

public class Ex1 {

	public static void main(String[] args) {
		A a = new B();
//		B b = new A();
		// A a <- 부모타입 변수

	}

}
