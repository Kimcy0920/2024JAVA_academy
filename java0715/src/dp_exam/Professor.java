package dp_exam;

public class Professor {
	private Student student;
	
	public void setStudent(Student student) { //get 보내기, set 받기
		this.student = student;
	}
	
	public void advise() {
		System.out.println("상담 내용:");
	}
	
}
