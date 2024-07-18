package exam;

public class Person {
	private Role role; // Person 1---> <<abstract>>Role
	// Role로부터 Person에 필드가 1개 생성
	// private, 필드로 직접 접근 불가능
	
	// get, set사용함
	public Role getRole() {
		return role;
	}

	// 생성자가 없음, set으로 접근
	public void setRole(Role role) {
		this.role = role;
	}

	public void doIt() {
		role.doIt();
	}
}
