package dp;

public class Person1 { // Person.java보다 좋은코드
	
//	private Phone[] phones;	
//	public Person() {
//		phones = new Phone[2]; // ex) 집 전화번호와 회사 전화번호 2개
//	}
	
	private Phone homePhone; // 접근방식을 private로 집과 회사 2개를 받음
	private Phone officePhone; 
	
	public Phone getHomePhone() { // getter, setter 방식
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
