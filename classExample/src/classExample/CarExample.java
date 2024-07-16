package classExample;

public class CarExample {

	public static void main(String[] args) {
		
		// 0. 객체 생성 myCar
		Car myCar = new Car("아우디", "R8", "흰색", 400, 100); // 1. 기본 생성자 호출
							   // 3. 기본 생성자가 없어 에러발생.
		
		// 필드값 열기
		System.out.println("브랜드: " + myCar.company);
		System.out.println("모델: " + myCar.model);
		System.out.println("색상: " + myCar.color);
		System.out.println("최고속도: " + myCar.maxSpeed);
		System.out.println("현재속도: " + myCar.speed);

		// 필드값 변경
		myCar.speed = 60;
		
		System.out.println("수정된 속도: " + myCar.speed);
	}

}
