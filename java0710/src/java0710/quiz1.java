package java0710;

public class quiz1 {

	public static void main(String[] args) {
		int i = 0;
		int j = 0;
		int sum = 0;
		
		for (i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				sum += i;
				continue;
			}
			System.out.println(i);
		}
		System.out.println(sum);
		
//		for (i = 2; i <= 9; i++) {
//			for (j = 1; j <= 9; j++) {
//				System.out.printf("%d X %d = %d\t", i, j, i*j);
//			}
//			System.out.println();
//		}
		
//		for (j = 1; j <= 9; j++) {
//			for (i = 2; i <= 9; i++) {
//				System.out.printf("%d X %d = %d\t", i, j, i*j);
//			}
//			System.out.println();
//		}
		
//		while (i <= 100) {
//			sum += i;
//			i++;
//		}
//		System.out.println(sum);
		
//		for (float a = 0.1f; a <= 1.0f; a+=0.1f) {
//			System.out.println(a);
//		}
	}

}
