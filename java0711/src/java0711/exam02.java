package java0711;

import java.util.Scanner;

public class exam02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		int n = Integer.parseInt(input);
		
		do { // do-while문을 통해 0 이하의 값이면 반복
			System.out.print("n값: ");
			n = scan.nextInt();
		} while (n <= 0);
		
		int sum = 0;
		
		for (int i = 1; i <= n; i++) {
			sum = sum + i;
		}
		System.out.println("1부터" + n + "까지의 합은" + sum + "입니다.");
	}

}
// 문제2. for문을 이용하여 1부터 n까지의 합을 구하세요. (n은 입력받은 정수)