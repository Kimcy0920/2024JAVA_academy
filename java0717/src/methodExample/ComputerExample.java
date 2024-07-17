package methodExample;

public class ComputerExample {

	public static void main(String[] args) {
		Computer myCom = new Computer();
		
		int[] values = {1, 2, 3};
		int res1 = myCom.sum1(values);
		System.out.println(res1);
		
		int res2 = myCom.sum2(new int[] {1, 2, 3, 4, 5} );
		System.out.println(res2);

		int res3 = myCom.sum2(1, 2, 3, 4);
		System.out.println(res3);
		
	}

}
