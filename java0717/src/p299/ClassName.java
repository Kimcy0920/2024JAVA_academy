package p299;

public class ClassName {
	//인스턴스 필드와 메소드
	int field1; // 메모리에 올라가 있지 않은 상태, 객체를 생성해야 사용가능
	void method1() {
//		field2 = 100; // 같은 코드
		ClassName.field2 = 200;
		this.field1 = 300;
	}
	
	//정적 필드와 메소드
	static int field2; // static <-메모리에 올라가 바로 실행 가능한 상태
	static void method2() {
//		this. // 에러
		field2 = 100;
	}
	
	public static void main(String... ar) {
//		field1 = 10; // 컴파일 에러
//		method1();
		
		ClassName.method2();
		System.out.println(ClassName.field2);
//		method2();
//		field2 = 10; // 같은 코드, ClassName소속
		
		ClassName c1 = new ClassName();
		c1.method1();
		System.out.println(c1.field1);
	}
}
