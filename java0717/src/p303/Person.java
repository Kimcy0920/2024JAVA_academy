package p303;

public class Person {
//	String nation = "Korean"; // main에서 값 변경가능
	final String nation = "Korean";
	static final double Pi = 3.141592; // static final(상수)
	
	public static void main(String[] args) {
		Person p1 = new Person();
//		p1.nation = "USA"; // final, 변경 불가능
//		PI = 3.14; // static final(상수) 변경 불가능
		System.out.println(p1.nation);
	}
}