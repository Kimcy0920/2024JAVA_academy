package dp;

import java.util.Vector;

public class Student {
	private Professor advisor;
	
	
	private String name;
	private Vector<Course> courses; // course를 여러 개 등록할 수 있음 // 1..* 하나 이상 수강
	

	public Student() {} // defalut 생성자를 만들어서 Main.java 오류를 없앰
	
	public Student(String name) {
//		super();
		this.name = name;
//		this.courses = course;  // Main 오류 지점: NullPointException line16 해결방식
		this.courses = new Vector<Course>();
	}
	
	public void registerCourse(Course course) {
		courses.add(course);
	}
	
	public void dropCourse(Course course) {
		if (courses.contains(course)) { // 코스가 없는데 remove를 하면 에러발생함
			courses.remove(course); // 코스가 있으면 삭제
		}
	}

	// 이전꺼
	public void setAdvisor(Professor advisor) {
		this.advisor = advisor;
	}

	public void advise(String msg) {
		System.out.println(msg);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
