package java0709;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫번째 숫자: ");
		String input = scan.nextLine();
		int a = Integer.parseInt(input);

		System.out.print("두번째 숫자: ");
		input = scan.nextLine();
		int b = Integer.parseInt(input);

		System.out.print("세번째 숫자: ");
		input = scan.nextLine();
		int c = Integer.parseInt(input);
		
		if (a > b && a > c) {
			System.out.printf("%d", a);
		} else if (b > a && b > c) {
			System.out.printf("%d", b);
		} else {
			System.out.printf("%d", c);
		}
	}

}
// 4. 3개의 정수 값을 받아서 최대값을 구하여 출력하시오.