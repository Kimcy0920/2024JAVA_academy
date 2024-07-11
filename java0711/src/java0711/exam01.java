package java0711;

import java.util.Scanner;

public class exam01 {
	
	public static int getNum(int a, int b, int c) {
		
		if ((b >= a && c <= a) || (b <= a && c >= a)) {
			return a;
		} else if ((a > b && c < b) || (a < b && c > b)) {
			return b;
		}
		return c;
	}
		
//		if (a >= b) {
//			if (b >= c) {
//				return b;
//			} else if (b <= c) {
//				return a;
//			} else {
//				return c;
//			}
//		} else if (a > c) {
//			return a;
//		} else if (b > c) {
//			return c;
//		} else {
//			return b;
//		}
//	}

	public static int getCount(String msg, Scanner scan) {
		System.out.print(msg);
		String input = scan.nextLine();
		return Integer.parseInt(input);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a = getCount("숫자 입력: ", scan);
		int b = getCount("숫자 입력: ", scan);
		int c = getCount("숫자 입력: ", scan);
		
		// 메서드로 만들기
		if (a >= b) {
			if (b >= c) {
				System.out.println(b);
			} else if (a <= c) {
				System.out.println(a);
			} else {
				System.out.println(c);
			}
		} else if (a > c) { // a는 b보다 작다
			System.out.println(a);
		} else if (b > c) { // b는 c보다 작다
			System.out.println(c);
		} else { // a는 b보다 작다, a는 c보다 작거나 같다, b는 c보다 작거나 같다
			System.out.println(b);
		}
	}

}
// 문제. 3개의 정수값을 입력받아 중앙값을 구하고 출력하세요.