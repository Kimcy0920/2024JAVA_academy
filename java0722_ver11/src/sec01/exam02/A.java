package sec01.exam02;

public class A { // 외부 클래스
	B field1 = new B();
	C field2 = new C();
	
//	static B field3 = new B(); // 에러, 인스턴스 클래스여서 static로 생성 불가능함.
	static C field4 = new C();
	
	void method1() {
		B var1 = new B();
		C var2 = new C();
	}
	
	static void method2() {
//		B var1 = new B(); // 에러, static으로 선언되었으면 static만 가능
		C var2 = new C();
	}
	
	// 내부 클래스
	class B {} // 인스턴스 멤버
	static class C {} // 정적 멤버
			
}
