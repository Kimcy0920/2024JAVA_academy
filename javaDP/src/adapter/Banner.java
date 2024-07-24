package adapter;

public class Banner {
	private String string; // 필드
	
	public Banner(String string) { // 생성자(매개값 1개)
		this.string = string;
	}
	
	public void showWithParen() { // 메소드
		System.out.println("(" + string + ")");
	}
	
	public void showWithAster() { // 메소드
		System.out.println("*" + string + "*");
	}
}

// https://refactoring.guru/ko/design-patterns 디자인 패턴들