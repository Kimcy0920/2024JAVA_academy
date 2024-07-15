package dp_exam;

public class Main {
	public static void main(String[] args) {
		Professor pro = new Professor();
		Student stu = new Student();
		
		pro.setStudent(stu);
		pro.advise();
	}
}
