package java0710;

import java.util.Scanner;
public class kim {
    public static int getNum(String msg,Scanner scan) {
    	System.out.println(msg);
		String input1 = scan.nextLine();
		return Integer.parseInt(input1);
    }

	public static void main(String[] args) {
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("-----------------------------");
			System.out.println("1.예금 | 2.출금 |3.잔고 | 4.종료 ");
			System.out.println("-----------------------------");
			int select = getNum("선택>",sc);
			
			if(select == 1) {
				int money = getNum("예금액>",sc);
				balance += money;
			}
			if(select == 2) {
				int money = getNum("출금액>",sc);
				balance -= money;
			}
			if(select == 3) {
				System.out.println("잔고> ");
				System.out.println(balance);
			}
			if(select == 4) {
				run = false;
			}
			
			}
		System.out.println("프로그램 종료");
		}

	}


