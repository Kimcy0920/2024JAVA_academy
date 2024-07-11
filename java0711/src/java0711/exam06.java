package java0711;

import java.util.Scanner;

public class exam06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("n값 입력: ");
		int n = scan.nextInt();
		System.out.print("w값 입력: ");
		int w = scan.nextInt();
		
		for (int i = 0; i < n; i++) {
			if (i % w == 0) {
				System.out.println();
			}
			System.out.print("*");
		}
		
		int a, b;
		
		System.out.println("*를 n개 출력하되 w개마다 줄을 바꿔서 출력합니다.");
		
		do {
			System.out.print("n값: ");
			a = scan.nextInt();
		} while (a <= 0);
		
		do {
			System.out.print("w값: ");
			b = scan.nextInt();
		} while (a < b || b <= 0); // a가 b보다 작다, b가 0보다 작거나 같다

		for (int i = 0; i < a; i++) {
			System.out.print("*");	
			if (i % b == b-1) {
				System.out.println();
			}
		}
		if (a % b != 0) {
			System.out.println();
		}
		System.out.println("완료!!");
	}

}
// 문제6. *를 n개를 출력하되 w개 마다 줄을 바꿔서 출력하는 프로그램을 작성하세요.
// n = 14, w = 5 (n > w, w > 0)
// *****
// *****
// ****