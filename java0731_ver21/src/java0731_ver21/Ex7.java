package java0731_ver21;

public class Ex7 {
	public static void personInfo(Person person) {
		System.out.println("name : " + person.name);
		person.walk();
		
		if (person instanceof Student student) { // 강제 형 변환까지 처리
			student.study();
		}
		
//		if(person instanceof Student) {
//			Student student = (Student) person;
//			student.study();
//		} else {
//			System.out.println("형 변환 불가능");
//		}
	}
	
	public static void main(String[] args) {
		Person p1 = new Person("엄복동");
		personInfo(p1);
		
		System.out.println("--------------");
		
		Student s1 = new Student("양금모", 30);
		personInfo(s1);
	}
}
