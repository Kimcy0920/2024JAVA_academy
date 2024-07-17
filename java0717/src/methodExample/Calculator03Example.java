package methodExample;

public class Calculator03Example {

	public static void main(String[] args) {
		Calculator03 cal = new Calculator03();
		
		double res1 = cal.areaRectangle(10);
		double res2 = cal.areaRectangle(10, 20);
		
		System.out.println("직사각형 넓이: " + res1);
		System.out.println("정사각형 넓이: " + res2);

	}

}
