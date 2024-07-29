package sec01.exam07;

public class MainThreadEx {

	public static void main(String[] args) {
		Calculator calculator = new Calculator(); // 계산기 생성

		User1 user1 = new User1(); // 사용자1
		user1.setCalculator(calculator); // setter에 의한 주입
		user1.start(); // 첫번째 계산기 set, start
		
		User2 user2 = new User2();
		user2.setCalculator(calculator);
		user2.start();
	}

}
