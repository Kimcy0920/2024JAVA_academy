package java0709;

public class Ex02 {

	public static void main(String[] args) {
		
		float f1 = 3.14f;
		double d1 = 314e+2;
		System.out.println(d1);
		
		int sum;
		int s1 = 0;
		int s2;
//		sum = s1 + s2;
		
		int x1 = 100; // 전역
		
		if(true) {
			int x2 = 300; // 지역
			System.out.println(x1);
		}
//		System.out.println(x2);
	}

}