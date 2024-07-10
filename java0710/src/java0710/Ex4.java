package java0710;

import java.util.Scanner;

public class Ex4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (;;) {
			System.out.println("명령>>");
			String input = scan.nextLine();
			if (input.equalsIgnoreCase("q")) {
				break;
			}
		}
		System.out.println("종료");
	}

}
