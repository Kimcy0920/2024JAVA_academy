package dp_exam;

import dp.Phone;

public class Person01 {
	private Phone[] phones; // phone를 배열로 받음
	
	// 생성자는 클래스와 이름이 같은 메서드
	// public 사용, 필드 초기화
	
	public Person01() {
		phones = new Phone[2]; // ex) 배열크기 2로 집과 회사 번호
	}
	
	public Phone getPhone(int i) { // 나쁜 설계 예시
		if (i == 0 || i == 1) {
			return phones[i]; // 0일 때는 집 전화, 1일 때는 회사
		}
		return null;
	}
}
