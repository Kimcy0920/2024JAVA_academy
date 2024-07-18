package java0718;

public abstract class Phone { // main에서 객체 생성만 못함
	// 추상클래스는 필드, 생성자, 메서드 다 가능/ 객체 생성만 불가능
	// 인터페이스는 메서드만 가능
	String name;
	
	void turnOn() {
		System.out.println("전원켜기");
	}
	
	abstract void turnOff(); // SmartPhone에서 에러, turnOff를 강제로 오버라이드해야함
//	void turnOff() {
//		System.out.println("전원끄기");
//	}
	
}
