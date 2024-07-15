package dp;

import java.util.Vector;

// protected, private, public, default

/* Course(Class)
 * - id : String
 * - name : String
 * - numOfStudent : Integer = 0
 * ---------------------------------
 * + addStudent()
 * + deleteStudent()
 * 
 * -: private, +: public
 */

public class Course {
	private String id;
	private String name; // 코스에서 중요한 정보
	private int numOfStudent= 0;
//	private integer numOfStudent= 0; // 8번과 같음
	
	private Vector<Student> students;
	
	public Course(String id, String name) {
//		super();
		this.id = id;
		this.name = name;
		this.students = new Vector<Student>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addStudent(Student student) {
		students.add(student);
		++numOfStudent;
	}
	
	public void deleteStudent(Student student) {
		if (students.contains(student)) { // 코스가 없는데 remove를 하면 에러발생함
			students.remove(student); // 코스가 있으면 삭제
			--numOfStudent;
		}
	}
	// -------------------------------------------------------------------- error, main2 코스별 신청자 출력 스택오버플로

	public Vector<Student> getStudents() {
		return students;
	}
	// toString을 없애고 getter로 getStudents 생성

	public void setStudents(Vector<Student> students) {
		this.students = students;
	}

	public int getNumOfStudent() {
		return numOfStudent;
	}

	public void setNumOfStudent(int numOfStudent) {
		this.numOfStudent = numOfStudent;
	}

}
