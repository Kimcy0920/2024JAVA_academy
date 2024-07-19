package sec05.exam03;

public class Car {
	int speed;
	
	void run() {
		System.out.println(speed + "으로 달립니다.");
	}
	
	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.speed = 60;
		myCar.run();
	}

}

/*
 * 인스턴스 멤버는 객체 생성을 하고 사용해야함.
 * 그러나 static(정적)이 붙으면 클래스가 실행되면서 바로 사용가능하기 때문에 객체 생성이 따로 필요없음
 * 
 * 정적 메서드에서 인스턴스 멤버를 사용하려면 객체 생성 후 참조 변수로 접근해야함
 * [main도 static가 붙어있으므로 정적, 그래서 객체 생성을 해서 사용하는 것]
*/