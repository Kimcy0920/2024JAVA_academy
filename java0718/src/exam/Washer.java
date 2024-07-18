package exam;

public class Washer extends HomeAppliancies	{

	@Override
	public void turnOn() {
		System.out.println("세탁기 전원 켜짐");
	}

	@Override
	public void turnOff() {
		System.out.println("세탁기 전원 꺼짐");
	}
	
	
}
