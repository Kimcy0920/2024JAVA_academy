package java0722;

////p.429 중첩 클래스: 클래스 안에 클래스
//public class A {
//	class B {} // 인스턴스 클래스, A$B.class
//	static class C {} // 정적 클래스, A$C.class
//	
//	public static void main(String[] args) {
//		class D {} // 로컬 클래스, A$1D.class
//		class E {} // 로컬 클래스, A$1E.class
//	}
//	
//	void method() {
//		class F {} // 메소드 내부, 로컬 클래스 A$1F.class
//	}
//}

//p.430 중첩 클래스
public class A {
	class B {
		int field1;
		static int field2;
		void method1() {}
		static void method2() {}
	}
	
	public static void main(String[] args) {
		System.out.println(A.B.field2);
		
		A a = new A(); // 객체생성
		A.B b = a.new B(); // A의 B 클래스 객체 생성
		b.method1();
	}
}
