package java0712;

import java.util.Scanner;

public class Prob01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("학생수 입력: ");
		int num = Integer.parseInt(scan.nextLine());
		double scores[][] = new double[num][3]; // 국어, 수학 , 평균
		
		for (int i = 0; i < num; i++) { // 입력한 학생 수 만큼
			System.out.println(i+"번째 학생");
			System.out.print("국어 점수: ");
			scores[i][0] = Double.parseDouble(scan.nextLine()); // 국어
			System.out.print("수학 점수: ");
			scores[i][1] = Double.parseDouble(scan.nextLine()); // 수학
			
			scores[i][2] = (scores[i][0] + scores[i][1]) / 2; // 평균
			// scores[i][0] 국어 scores[i][1] 수학 scores[i][2] 평균
		}
		
		for(int i = 0; i < scores.length; i++) {
			System.out.println(i+"번째 학생");
			System.out.println("국어: " + scores[i][0]);
			System.out.println("수학: " + scores[i][1]);
			System.out.println("평균: " + scores[i][2]);
		}
	}

}
// 문제1. 2차원 배열을 이용하여 국어점수와 수학점수를 입력받아서 학생별 평균을 출력하는 프로그램을 작성하세요.
// double scores[][] = new double [num][3];
// 국어[0], 수학 [1], 평균[2]