package p367;

import java.util.Scanner;

public class DriverEx {

	public static void main(String[] args) {
//		Driver driver = new Driver();
//		Vehicle vehicle = new Vehicle();
////		Bus bus = new Bus();
//		Vehicle bus = new Bus(); // bus객체생성을 부모클래스인 Vehicle로도 가능.
//		Taxi taxi = new Taxi(); // Taxi도 Vehicle의 자식이므로 부모타입 변수 사용 가능.
//		
//		driver.drive(vehicle);
//		driver.drive(bus);
//		driver.drive(taxi);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("차량을 선택하세요(1.버스 | 2.택시)");
		int num = scan.nextInt();
		
		Driver driver = new Driver();
		Vehicle v1 = null;
		switch(num) {
			case 1: v1 = new Bus();
				break;
			case 2: v1 = new Taxi();
				break;
			default:
				System.out.println("선택 오류");
		
		}
		driver.drive(v1);
	}

}
