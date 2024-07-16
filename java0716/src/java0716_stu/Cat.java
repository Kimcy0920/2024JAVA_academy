package java0716_stu;

public class Cat {
	String breed;
	String color;
	int age = 0;
	
	Cat() { // 기본 생성자.  
		System.out.println("Cat()"); // print문으로 확인, 생성자는 return타입 int, void불가능
	}
	
	public Cat(String breed) {
//		super(); 생성자는 생성을 먼저해야하기 때문에 그 위에 어떤 코드도 올 수 없음
		this(breed, "흰색", 10);
	}

	public Cat(String breed, String color) {
		super();
		this.breed = breed;
		this.color = color;
	}

	public Cat(String breed, String color, int age) {
		super();
		this.breed = breed;
		this.color = color;
		if (age > 9) {
			this.age = age;
		} else {
			this.age = 10;
		}
		
	}
	
	@Override // 재정의
	public String toString() {
		return "고양이 [품종=" + breed + ", 색상=" + color + ", 나이=" + age + "]";
	}

	//------------------get, set----------------------
	
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age > 9) {
			this.age = age;
		} else {
			this.age = 10;
		}
	}
// 메서드 getter, setter, toString

}
