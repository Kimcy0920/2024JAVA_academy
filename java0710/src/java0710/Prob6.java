package java0710;

import java.util.Scanner;

public class Prob6 {

	public static void main(String[] args) {
		System.out.print("정수 입력:");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		
		if (input < 0) {
			input = input * -1;
		}
		System.out.println(input);
	}

}
