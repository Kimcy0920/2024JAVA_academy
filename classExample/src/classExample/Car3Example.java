package classExample;

public class Car3Example {

	public static void main(String[] args) {
		Car03 car1 = new Car03();
		Car03 car2 = new Car03("그랜저");
		Car03 car3 = new Car03("그랜저", "검은색");
		Car03 car4 = new Car03("그랜저", "검은색", 350);
		
		System.out.println(car1.company);
		System.out.println(car2.company + ", " + car2.model);
		System.out.println(car2.company + ", " + car2.model + ", " + car3.color);		
		System.out.println(car4.company + ", " + car4.model + ", " + car4.color + ", " + car4.maxSpeed);
	}

}
