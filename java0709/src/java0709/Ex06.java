package java0709;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력: ");
		String input = scan.nextLine();
		int num = Integer.parseInt(input);
		
		if (num > 0) {
			System.out.printf("%d", num);
		} else {
			System.out.printf("%d", num * -1);
		}
	}

}
// 6. 정수의 값을 입력받고 입력받은 값이 양의 정수이면 그냥 출력하고, 음의 정수이면 양의 정수로 변환하여 출력하세요.