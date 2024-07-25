package sec01.exam06;

public class RemoteControlExample {

	public static void main(String[] args) {
//		RemoteControl rc = new RemoteControl(); 인터페이스여서 객체 생성 불가능
		RemoteControl rc; // rc로 
		rc = new Television();
		rc = new Audio();
	}

}
