package java0710;

import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {
		// 3번. 두 개의 값을 받아서 큰 수를 출력하세요. (단, 같으면 0으로 출력)
		// 변수 2개 필요
		Scanner scan = new Scanner(System.in); // system.in <- 키보드 입력
		String str1, str2;
		int in1;
		int in2;
		int result = 0;
		
		for (;;) {
			System.out.print("첫 번째 숫자를 입력:");
			str1 = scan.nextLine();
			
			System.out.print("두 번째 숫자를 입력:");
			str2 = scan.nextLine();
			
			in1 = Integer.parseInt(str1);
			in2 = Integer.parseInt(str2);
			
			if (in1 > in2) {
				result = in1;
			} else if (in1 == in2) {
				result = 0;
			} else {
				result = in2;
			}
			System.out.println(result);
		}
	}

}
