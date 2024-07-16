package classExample;

public class Car {
	// 필드
	String company = "현대";
	String model = "그랜저";
	String color = "검정";
	int maxSpeed = 350;
	int speed; // 초기값 지정x, 기본 초기값 0
	
//	public Car () { // 4. 기본 생성자를 만들어 에러가 사라짐.
//		this("람보르기니", "레벤톤", "회색", 420, 100);
//	}
	
	// 2. 이미 만들어진 다른 생성자가 존재해 기본생성자가 만들어지지 않음.
	public Car(String company, String model, String color, int maxSpeed, int speed) {
		super();
		this.company = company;
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
		this.speed = speed;
	}
	
	
}
