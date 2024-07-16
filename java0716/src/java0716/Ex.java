package java0716;

public class Ex {

	public static void main(String[] args) {
//		Cat cat = new Cat(); // 객체 생성, Cat.java <- Cat(int age) {} 생성자를 만들면 에러발생
		Cat cat = new Cat("페르시안", "검정", 9);
//		System.out.println(cat.age);
		cat.setAge(9);
		System.out.println(cat);
		
		Calculator calculator = new Calculator();
		
		System.out.println(calculator);
	}

}
