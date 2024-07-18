package exam;

public class PersonEx {

	public static void main(String[] args) {
		Driver driver = new Driver();
		Role role = driver;
//		role = new Worker(); // 필드 다형성
		
		role = new Worker();
		if (role instanceof Worker) { // 인터페이스 강제형변환
			Worker worker = (Worker) role;
		}
		
		
		Person person = new Person(); // person 객체 생성
//		person.getRole().MAX = 100; // 상수여서 못 바꿈
		
		// 역할부여
//		person.doIt(); NullPointerException 에러, role 객체가 없음(null)
		
		person.setRole(new Driver()); // 필드값 role은 private
		person.doIt();				  // set을 통해 객체 생성
		person.setRole(new Worker());
		person.doIt();
	}

}
