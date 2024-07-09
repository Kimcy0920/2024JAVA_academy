package java0709;

import java.util.Scanner;

public class ScannerEx01 {
	public static int getCount(String msg, Scanner sc) {
		System.out.print(msg);
		String input = sc.nextLine();

		return Integer.parseInt(input);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int apple = getCount("사과 갯수: ", scan);
//		System.out.print("사과 갯수: ");
//		String input = scan.nextLine();
//		int apple = Integer.parseInt(input);
		
		int people = getCount("친구 수: ", scan);
//		System.out.print("친구 수: ");
//		input = scan.nextLine();
//		int people = Integer.parseInt(input);
		
		int remainder = apple % (people+1);
		System.out.printf("남은 사과 갯수: %d", remainder);
	}

}
