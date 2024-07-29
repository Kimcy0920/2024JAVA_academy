package sec01.exam02;

public class MemberEx {

	public static void main(String[] args) {
		Member obj1 = new  Member("blue");
		Member obj2 = new  Member("blue");
		Member obj3 = new  Member("red");
		
		if(obj1.equals(obj2)) {
			System.out.println("obj1과 obj2는 동등합니다.");
		} else {
			System.out.println("obj1과 obj2는 동등하지 않습니다.");
		}

		if(obj1.equals(obj3)) {
			System.out.println("obj1과 obj3는 동등합니다.");
		} else {
			System.out.println("obj1과 obj3는 동등하지 않습니다.");
		}
		
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());
	}

}
/*
 * equals() 메소드의 매개 타입은 Object, 모든 객체는 오브젝트 타입으로 자동변환 가능
 * equals()는 ==와 동일한 결과 리턴
 * 
 * 두 객체를 동등비교 시 equals 사용, 객체가 저장하고 있는 데이터가 동일함을 뜻함
 * 
 * String 객체의 equals는 문자열 번지 비교가 아닌 문자열이 동일한지를 비교함
 * String 클래스가 Object의 equals 메소드를 재정의해서 번지가 안니 문자열 비교로 변경했기 때문.
 * 
 * equals 재정의 시 매개값이 기준 객체와 동일한지 확인 (instanceof)
 * 동일한 타입일 시 강제 타입변환
*/