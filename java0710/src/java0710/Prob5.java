package java0710;

import java.util.Scanner;

public class Prob5 {

	public static void main(String[] args) {
	// 5. 100점 만점의 학점을 입력받아서 90점 이상이면 A, 80점 이상이면 B, 70점 이상이면 C, 60점 이상이면 D, 60점 미만이면 F를 구하는 프로그램을 작성하세요.
		Scanner scan = new Scanner(System.in);
		System.out.print("학점을 입력하세요: ");
		String input = scan.nextLine();
		int num = Integer.parseInt(input);
		String score = "";
		
//		if (num >= 90) {
//			score = "A";
//		} else if(num >= 80) {
//			score = "B";
//		} else if(num >= 70) {
//			score = "C";
//		} else if(num >= 60) {
//			score = "D";
//		} else {
//			score = "F";
//		}
		
//		switch(num/10) {
//		// 몫 계산
//		case 10:
//		case 9:
//			score = "A";
//			break;
//		case 8:
//			score = "B";
//			break;
//		case 7:
//			score = "C";
//			break;
//		case 6:
//			score = "D";
//			break;
//		default:
//			score = "F";
//		}
		score = (num >= 90) ? "A" :
					(num >= 80) ? "B" :
						(num >= 70) ? "C" :
							(num >= 60) ? "D" : "F";
		
		System.out.println("학점: " + score);
	}

}
