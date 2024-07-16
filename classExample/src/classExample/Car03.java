package classExample;

public class Car03 {
	String company = "현대";
	String model;
	String color;
	int maxSpeed;
	
	Car03() {} // 생성자1
	
	Car03(String model) { // 생성자2
		this.model = model;
	}
	
	Car03(String model, String color) { // 생성자3
		this.model = model;
		this.color = color;
	}
	
	Car03(String model, String color, int maxSpeed) { // 생성자4
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
