package classExample;

public class Car4Example {

	public static void main(String[] args) {
		Car04 car1 = new Car04();
		Car04 car2 = new Car04("자가용");
		Car04 car3 = new Car04("그랜저", "빨강");
		Car04 car4 = new Car04("택시", "검정", 200);
		
		System.out.println("car1: " + car1.company);
		System.out.println("car2: " + car2.company + ", " + car2.model);
		System.out.println("car3: " + car2.company + ", " + car2.model + ", " + car3.color);		
		System.out.println("car4: " +car4.company + ", " + car4.model + ", " + car4.color + ", " + car4.maxSpeed);
	}

}
