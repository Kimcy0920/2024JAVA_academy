package java0710;

import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		boolean run = true;
		int balance = 0;
		Scanner scan = new Scanner(System.in);
		
		while(run) {
			System.out.println("----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("----------------------------");
			System.out.print("선택> ");
			String input = scan.nextLine();
			int num = Integer.parseInt(input);
			
			if (num == 1) {
				System.out.print("예금액> ");
				input = scan.nextLine();
				balance = Integer.parseInt(input);
				System.out.println("예금액>" + balance);
				
				if (num == 2) {
					System.out.print("출금액> ");
					input = scan.nextLine();
					int m = Integer.parseInt(input);
					balance -= m;
					System.out.println(m);
				}
			}
			if(num == 4) {
				break;
			}
			
		}
		System.out.println("종료");
	}

}
