package java0725;

interface Parent2 { // 멤버 필드를 가질 수 없음
	void method();
}

public class Ex2 {

	public static void main(String[] args) {
		Parent2 parent2 = new Parent2() { // 인터페이스에서의 익명객체
			
			@Override
			public void method() { // 강제 재정의를 해야함, 구현 객체
				
			}
		};
	}

}
