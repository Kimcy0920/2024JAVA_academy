package dp;

public class Person {
	private Phone[] phones;
	
	// 생성자는 클래스와 이름이 같은 메서드
	// public 사용, 필드 초기화
	public Person() {
		phones = new Phone[2]; // ex) 집 전화번호와 회사 전화번호 2개
	}
	
	public Phone getPhone(int i) { // 나쁜 설계 예시
		if (i == 0 || i == 1) {
			return phones[i]; // 0일 때는 집 전화, 1일 때는 회사
		}
		return null;
	}
}
