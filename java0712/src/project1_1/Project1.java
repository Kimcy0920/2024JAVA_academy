package project1_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Project1 {

	public static void main(String[] args) {
//		Member[] list = null;
		Member[] list = new Member[10]; // 총 회원수 10명으로 제한
		int memCnt = 0; // 회원수
		try (FileInputStream fis = new FileInputStream("c:\\temp\\members.dat");
	             ObjectInputStream ois = new ObjectInputStream(fis)) {
//			list = (Member[]) ois.readObject(); // list를 그대로 사용하면 회원수 10명 제한둔게 초기화되버림
			Member[] list2 = (Member[]) ois.readObject(); // 지역변수 list2로 변경
			System.arraycopy(list2, 0, list, 0, list2.length); // 배열 복사 p.217
			System.out.println("파일에서 객체를 가져왔습니다.");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		for (Member member : list) {
//			System.out.println(member);
			if (member != null) {
				System.out.println(member);
				++memCnt; // ++가 앞이나 뒤 상관X
				// 실행시 배열 10칸 중 아직 값이 없는 곳이 null로 표시되는걸 안 보이게 함.
				// null이 아닌 경우 회원정보 출력, 파일에 저장된 인원들의 정보만 출력
			}
		}
		System.out.println("총회원수: " + memCnt);
		
		Member member = null; // 로그인된 현재 사용자
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1.로그인 | 2.회원가입 | 3.예금/출금 | 4.종료");
			System.out.println("-------------------------------------");
			System.out.print("선택> ");
			int menuNum = Integer.parseInt(scanner.nextLine());
			switch (menuNum) {
			case 1:
				// 로그인 처리
				System.out.println("로그인 처리");
				
				System.out.print("아이디:");  //출력문
				String name = scanner.nextLine(); // name 변수의 값 입력
				System.out.print("패스워드:");
				String strPassword = scanner.nextLine();//패스워드입력
//				if (name.equals(member.name)) {
//					if (strPassword.equals(member.ssn)) {
//						System.out.println("로그인 성공");
//					} else {
//						System.out.println("로그인 실패:패스워드가 틀림");
//					}
//				} else {
//					System.out.println("로그인 실패:아이디 존재하지 않음");
//				}
				int find = -1;  // 찾기 전 또는 못찾았을 때
				
				for (int i=0; i < list.length; i++) {
					if (list[i].name.equals(name) && list[i].ssn.equals(strPassword)) {
						find = i;
						member = list[i];
						break;
					}
				}
				break;
			case 2:
				// 회원 가입
				System.out.println("회원 가입");
				
				System.out.println("[필수 정보 입력]"); 
				System.out.print("1. 이름: ");
				String name2 = scanner.nextLine(); 
				System.out.print("2. 주민번호 앞 6자리: ");
				String ssn = scanner.nextLine(); 
				System.out.print("3. 전화번호: "); 
				String tel = scanner.nextLine();
				System.out.println();
				System.out.println("[입력된 내용]");
				System.out.println("1. 이름: " + name2);
				System.out.println("2. 주민번호 앞 6자리: " + ssn); 
				System.out.println("3. 전화번호: " + tel);
				// 객체 생성
				list[memCnt++] = new Member(name2, ssn, tel); // ++가 뒤에 붙어야함
				break;
			case 3:
				// 예금 출금
				System.out.println("예금 출금");
				boolean run2 = true;
				
				while (run2) {
					System.out.println("-------------------------------------");
					System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
					System.out.println("-------------------------------------");
					System.out.print("선택> ");
					int menuNum2 = Integer.parseInt(scanner.nextLine());
					switch (menuNum2) {
					case 1:
						System.out.print("예금액> ");
						member.balance += Integer.parseInt(scanner.nextLine());
						break;
					case 2:
						System.out.print("출금액> ");
						member.balance -= Integer.parseInt(scanner.nextLine());
						break;
					case 3:
						System.out.print("잔고> ");
						System.out.println(member.balance);
						break;
					case 4:
						run2 = false;
						break;
					}
					System.out.println();
				}
				System.out.println("예금/출금 프로그램 종료");
				break;
			case 4:
				try (FileOutputStream fos = new FileOutputStream("c:\\temp\\members.dat");
			             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
					
					 oos.writeObject(list);
			         System.out.println("객체를 파일에 저장했습니다.");
					
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				run = false;
				break;
			}
		}
		System.out.println("프로그램 전체 종료");
	}
}

// 1. 프로그램이 시작될 때, 파일에서 객체 배열을 읽어온다.
// 2. 로그인 시 객체 배열에서 검색하여 로그인 처리를 한다.
// 3. 회원가입 시 객체 배열에 추가한다. (배열 크기 초기에 결정: 예를 들어 총인원 10명 제한)
// 4. 프로그램이 종료되기 직전에 파일에 저장한다.