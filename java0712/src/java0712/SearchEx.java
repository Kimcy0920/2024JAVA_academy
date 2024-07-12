package java0712;

import java.util.Scanner;

public class SearchEx {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String a[] = {"Hello", "자바", "가나다", "동서울", "스프링"};
		String val = "동서울";
		
		System.out.print("찾을 문자열: ");
		val = scanner.nextLine();
		int find = -1; // 찾기 전 또는 못 찾았을 때
		
		for (int i = 0; i < a.length-1; i++) {
			if (a[i].equals(val)) { // 문자열 비교는 .equals() 사용, 기본은 a[i] == val
				find = i;
				break;
			}
		}
		System.out.println("index: " + find);
	}
}
