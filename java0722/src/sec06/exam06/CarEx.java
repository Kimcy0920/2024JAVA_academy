package sec06.exam06;

public class CarEx {
	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.setSpeed(-50);
		System.out.println("현재속도: " + myCar.getSpeed());
		// Car클래스 setSpeed메서드에 조건문 speed<0일 시 0으로 리턴
		
		myCar.setSpeed(60);
		System.out.println("현재속도: " + myCar.getSpeed());
		// setSpeed 조건에 맞아 setter로 입력한 값이 리턴
		
		if(!myCar.isStop()) {
			myCar.setStop(true);
		}
		// 
		
		System.out.println("현재속도: " + myCar.getSpeed() + ", " + myCar.isStop());
	}
}
