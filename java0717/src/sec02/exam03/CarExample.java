package sec02.exam03;

public class CarExample {

	public static void main(String[] args) {
		Car car = new Car();
		
		for(int i=1; i<=5; i++) {
			TireLoc problemLocation = car.run();
			
			switch(problemLocation) {
			case FrontLeftTire:
				System.out.println("앞왼쪽 HankookTire로 교체");
				car.frontLeftTire = new HankookTire("앞왼쪽", 15);
				break;
			case FrontRightTire:
				System.out.println("앞오른쪽 KumhoTire로 교체");
				car.frontRightTire = new HankookTire("앞오른쪽", 13);
				break;
			case BackLeftTire:
				System.out.println("뒤왼쪽 HankookTire로 교체");
				car.backLeftTire = new HankookTire("뒤왼쪽", 14);
				break;
			case BackRightTire:
				System.out.println("뒤오른쪽 KumhoTire로 교체");
				car.backRightTire = new HankookTire("뒤오른쪽", 17);
				break;
			case NoProblem:
				System.out.println("몬다이나이");
			}
			System.out.println("--------------------------");
		}
		
	}

}
