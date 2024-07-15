package dp_exam;

public class Person02 {
//	private Phone[] phones;	
//	public Person() {
//		phones = new Phone[2]; // ex) 집 전화번호와 회사 전화번호 2개
//	}
	
	private Phone homePhone; // Person01과 다르게 각각 집, 회사 번호로 받음
	private Phone officePhone; // get, set 방식
	
	public Phone getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(Phone homePhone) {
		this.homePhone = homePhone;
	}
	public Phone getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(Phone officePhone) {
		this.officePhone = officePhone;
	}
	
	
}
