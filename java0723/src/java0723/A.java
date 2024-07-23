package java0723;

// p.435

public class A {
	int field1; // 인스턴스 멤버
	void method1() {}
	
	static int field2; // 정적 멤버
	static void method2() {}
	
	class B { // A 클래스의 필드와 메서드를 사용하기 위해 A 클래스 안에 B 클래스를 넣음
		void method() { // B클래스 메소드 안에서 실행
//			field1 = 10;
//			method1();
		
			field2 = 10; // 인스턴스는 모든 멤버에 접근 가능
			method2();
		}
		
	}
	
	static class C {
		void method() {
//			field1 = 10; // 정적은 인스턴스 멤버에 접근 불가능
//			method1();
			
			field2 = 10;
			method2();
		}
	}

	
	public static void main(String[] args) {
		System.out.println(A.field2); // 정적은 정적끼리 가능, 정적은 객체를 생성 안해도 돼서 바로 호출됨
//		System.out.println(field1);
		
		A a = new A(); // 인스턴스 멤버는 객체 생성 후 호출해야함
		System.out.println(a.field1);

		
//		A.B b = new A.B(); // A 생성 후 B 생성이 아닌, A 안에 B를 생성
//		b.method();
	}
}
