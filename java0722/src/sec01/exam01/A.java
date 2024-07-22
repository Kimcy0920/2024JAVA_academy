package sec01.exam01;

public class A {
	A() { // A클래스의 생성자
		System.out.println("A 객체 생성");
	}
	
	class B { // javaSE-17, static를 안붙여도 static로 인식함,
		B() {
			System.out.println("B 객체 생성");
		}
		int field1;
		static int field2;
		void method1() {}
		static void method2() {}
	}
	
	static class C {
		C() {
			System.out.println("C 객체 생성");
		}
		int field1;
		static int field2;
		void method1() {}
		static void method2() {}
	}
	
	void method() { // 메소드 내에 클래스 선언(로컬 클래스)
		class D {
			D() {
				System.out.println("D 객체 생성");
			}
			int field1;
			void method1() {}
		}
		D d = new D();
		d.field1 = 3;
		d.method1();
	}
}


