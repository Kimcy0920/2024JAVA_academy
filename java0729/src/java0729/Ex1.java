package java0729;

import java.util.Date;

class Aa {
	String ss = "Aa 클래스";

	@Override // toString 재정의
	public String toString() {
		return "Aa [ss=" + ss + "]";
	}
	
}

public class Ex1 {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Date obj2 = new Date();
		System.out.println(obj1);
//		System.exit(0);
		System.out.println(obj2.toString()); // 객체 호출 시 toString를 사용, 생략해도됨
		Aa aa = new Aa();
		System.out.println(aa); // java0729.Aa@445b84c0 출력
//		System.out.println(aa.toString()); // toString 써도 값은 같음
		// line8-11. toString 재정의 시 Aa [ss=Aa 클래스] 출력
		
		Class clazz = Aa.class; // Aa.class 클래스 객체 얻기
		System.out.println(clazz);
		System.out.println(clazz.getName());
	}
}
