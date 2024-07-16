package java0716;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString // lombok은 class 위에다 작성.
@Setter
@Getter
@AllArgsConstructor // 매개변수가 전부 들어있는 생성자

public class Cat  { // extends Object {
	private String breed; // 품종
	private String color; // 색
	private int age; // 나이
	// private와 get, set은 연관관계, 자주 쓰임
	
// 필드
	
//	public Cat(String breed) { // ----(1) 이름이 같은 생성자이지만 매개변수가 다름, 오버로딩
////		super();
////		this.breed = breed;
//		// 생성자는 생성을 먼저해야하기 때문에 this 위에 어떤 코드도 올 수 없음
//		this(breed, "흰색", 10); // 다른 생성자 호출
//	}
//
//	public Cat(String breed, String color) { // ----(2)
////		super();
////		this.breed = breed;
////		this.color = color;
//		this(breed, color, 10);
//	}
//
//	public Cat(String breed, String color, int age) { // ----(3)
//		super(); // this. super.
//		// 생성자가 하는 일을 기록
//		this.breed = breed;
//		this.color = color;
//		if (age > 9) {
//			this.age = age;
//		} else {
//			this.age = 10;
//		}
//	}
//
	Cat() { // 기본 생성자.  
		System.out.println("Cat()"); // print문으로 확인, 생성자는 return타입 int, void불가능
	}
	
	Cat(int age) { // 생성자
		
	}

// 생성자
	
}
