package classExample;

public class Car04 {
	String company = "현대";
	String model;
	String color;
	int maxSpeed;
	
//	Car04() {} // 생성자1
//	
//	Car04(String model) { // 생성자2
//		this.model = model;
//		this.color = "은색";
//		this.maxSpeed = 250;
//	}
//	
//	Car04(String model, String color) { // 생성자3
//		this.model = model;
//		this.color = color;
//		this.maxSpeed = 250;
//	}
//	
//	Car04(String model, String color, int maxSpeed) { // 생성자4
//		this.model = model;
//		this.color = color;
//		this.maxSpeed = maxSpeed;
//	}
//		 중복된 코드가 많음
	
	Car04() {} // 생성자1
	
	Car04(String model) { // 생성자2
		this(model, "은색", 250);
		// 호출
	}
	
	Car04(String model, String color) { // 생성자3
		this(model, color, 250);
		// 호출
	}
	
	Car04(String model, String color, int maxSpeed) { // 생성자4
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
		// 공통 실행코드
	}
	
}
