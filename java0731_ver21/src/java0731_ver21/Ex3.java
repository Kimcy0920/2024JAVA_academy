package java0731_ver21;

public class Ex3 {

	public static void main(String[] args) {
		char grade = 'B';
		
		switch (grade) {
			case 'A', 'a' -> {
				System.out.println("우수 회원입니다.");
				System.out.println("감사합니다.");
			}
			case 'B', 'b' -> {
				System.out.println("일반 회원입니다.");
			}
			default -> System.out.println("손님입니다.");
		}

	}

}
// p.674 예제