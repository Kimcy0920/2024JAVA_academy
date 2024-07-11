package java0711;

import java.util.Scanner;

public class exam07 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a, b;
		
		System.out.println("2자리 양수 입력받기");
		
		do {
			System.out.print("값 입력: ");
			a = scan.nextInt();
		} while (a < 10 || 100 < a);
		
		System.out.println("값 출력: " + a);
	}

}
// 문제7. 2자리 양수를 입력받는 프로그램을 작성하세요.
// a = 5, a = 105, a = 57 --> a = 57