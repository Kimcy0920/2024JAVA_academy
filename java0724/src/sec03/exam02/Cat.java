package sec03.exam02;

public class Cat extends Animal {

	public void Cat() {
		this.kind = "포유류";
	}
	
	@Override
	public void sound() {
		System.out.println("야옹");
	}
	
}
