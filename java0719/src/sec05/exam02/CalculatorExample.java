package sec05.exam02;

public class CalculatorExample {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		double result1 = 10 * 10 * cal.pi;
		int result2 = cal.plus(10, 5);
		int result3 = cal.minus(10, 5);
		
		System.out.println("result1: " + result1);
		System.out.println("result2: " + result2);
		System.out.println("result3: " + result3);

	}

}
