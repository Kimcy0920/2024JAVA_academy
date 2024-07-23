
package java0723;

public class NestedClassExample {
	public static void main(String[] args) {
		Car myCar = new Car();
		
		Car.Tire tire = myCar.new Tire(); // instance
		
		Car.Engine engine = new Car.Engine(); // static
		
//		Car.Engine engine2 = myCar.new Engine();
	}
}
