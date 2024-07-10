package java0710;

import java.util.Scanner;

public class Prob4 {

	public static int maxNum(int x, int y, int z) {
	// 시그니처
	// 4번. 3개의 정수 값을 받아서 최대값을 구하여 출력하시오.
		int max = x;
		
		if (y > max) {
			max = y;
		} if (z > max) {
			max = z;
		}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("3개의 수를 입력:");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		System.out.println("최대값: " + maxNum(a, b, c));
	}

}
