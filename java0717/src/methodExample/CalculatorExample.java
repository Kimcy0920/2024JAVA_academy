package methodExample;

public class CalculatorExample {

	public static void main(String[] args) {
		Calculator myCalc = new Calculator();
		myCalc.powerOn();
		
		int res1 = myCalc.plus(5, 6);
		System.out.println(res1);
				
		double res2 = myCalc.divide(10, 4);
		System.out.println(res2);
		
		myCalc.powerOff();
	}

}
