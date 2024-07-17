package methodExample;

public class Car02Example {

	public static void main(String[] args) {
		Car02 myCar = new Car02();
		myCar.keyTurnOn();
		myCar.run();
		int speed = myCar.getSpeed();
		System.out.println("현재속도: " + speed + "km/h");
	}

}
