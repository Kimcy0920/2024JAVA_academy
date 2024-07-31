package java0731_ver21;

public class Ex6 {
	public static void method(Object object) {
		switch (object) {
			case Integer i -> System.out.println(i);
			case String i1 -> System.out.println(i1);
			case Double i2 -> System.out.println(i2);
			
			case null, default -> System.out.println("???");
		}
	}
	
	public static void main(String[] args) {
		method(100);
		method("앙");
		method(5.8);
		method('a');
	}
}
// p.678 예제