package java0711;

import java.util.Scanner;

public class Mini {
	public static void main(String[] args) {
		boolean run = true;
		boolean run2 = true;
		int balance = 0;
		String Iuser = "";
		String user = "";
		int userNum = 0; // 비밀번호
		String pNum = ""; //
		int pwd = 0; // 비밀번호. 주민번호 앞 6자리
		
		Scanner scan = new Scanner(System.in);
		
		while(run) {
			System.out.println("-------------------------------------");
			System.out.println("1.로그인 | 2.회원가입 | 3.예금/출금 | 4.종료");
			System.out.println("-------------------------------------");
			System.out.print("선택> ");
			int menuNum = Integer.parseInt(scan.nextLine());
			switch (menuNum) {
			case 1:
				System.out.println("로그인 처리");
				System.out.print("아이디: ");
				Iuser = scan.nextLine();
				System.out.print("패스워드: ");
				pwd = Integer.parseInt(scan.nextLine());
				
				if (Iuser.equals(user) && pwd == userNum) {
					System.out.println("로그인 성공");
				} else {
					System.out.println("로그인 실패");
				}
				// 회원가입 정보와 비교
				break;
			case 2:
				System.out.println("회원 가입");
				System.out.println("[필수 정보 입력]");
				System.out.print("1. 이름: ");
				user = scan.nextLine(); // 문자열
				System.out.print("2. 주민번호 앞 6자리: ");
				userNum = Integer.parseInt(scan.nextLine());
				System.out.print("3. 전화번호: ");
				pNum = scan.nextLine(); // 문자열
				System.out.println();
				System.out.println("[입력된 내용]");
				System.out.println("1. 이름: " + user);
				System.out.println("2. 주민번호 앞 6자리: " + userNum);
				System.out.println("3. 전화번호: " + pNum);
				break;
			case 3:
				System.out.println("예금/출금");
				while(run2) {
					System.out.println("-----------------------------");
					System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
					System.out.println("-----------------------------");
					System.out.print("선택> ");
					int menuNum2 = Integer.parseInt(scan.nextLine());
					switch (menuNum2) {
					case 1:
						System.out.print("예금액> ");
						balance += Integer.parseInt(scan.nextLine());
						break;
					case 2:
						System.out.println("출금액> ");
						balance -= Integer.parseInt(scan.nextLine());
						break;
					case 3:
						System.out.println("잔고> ");
						System.out.println(balance);
						break;
					case 4:
						System.out.println("4");
						run2 = false;
					}
				}
				System.out.println("예금/출금 프로그램 종료");
				break;
			case 4:
				run = false;
			}
			run2 = true;
		}
		System.out.println("프로그램 전체 종료");
	}
}
// 회원가입 기능, 로그인 기능, 예금/출금/조회/종료 기능