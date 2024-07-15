package dp;

public class Professor { // 교수 클래스
	private Student student; // 학생 한명 만듦
	
	public void setStudent(Student student) {
		this.student = student;
	}

	// 생성자가 없으면 JVM이 default 생성자를 쓸 수 있게 만듦
	
	public void advise() {
		System.out.println("상담 내용은 여기에 작성: ");
		
	}
}
