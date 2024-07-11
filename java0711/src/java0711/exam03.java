package java0711;

import java.util.Scanner;

public class exam03 {
	
	public static int getCount(String msg, Scanner scan) {
		System.out.print(msg);
		String input = scan.nextLine();
		return Integer.parseInt(input);
	}

	public static int sumOf(int a, int b) {
		int max = 0; // a, b 중 큰 값
		int min = 0; // a, b 중 작은 값
		
		if (a < b) { // sumOf(4, 2) a가 더 큰 경우
			min = a;
			max = b;
		} else {
			min = b;
			max = a;
		}
		int sum = 0;
		for (int i = min; i <= max; i++) {
			sum += i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a = getCount("숫자 입력: ", scan);
		int b = getCount("숫자 입력: ", scan);

		System.out.println("a부터 b까지의 합: " + sumOf(a, b));
		
//		int sum = 0;
//		
//		for (int a = 2; a <= b; a++) {
//			sum += a;
//		}
//		System.out.println(sum);
	}

}
// 문제3. 정수 a, b를 포함하여 그 사이의 모든 정수의 합을 구하여 반환하는 메서드르 작성하세요.
// sumOf(2, 4) / sumOf(4, 2)