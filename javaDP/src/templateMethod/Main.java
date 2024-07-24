package templateMethod;

public class Main {

	public static void main(String[] args) {
		AbstractDisplay d1 = new CharDisplay('H');
		d1.display(); // 실행문
		
		//
		AbstractDisplay d2 = new StringDisplay("Hello"); // 다형성
		d2.display();
	}

}
