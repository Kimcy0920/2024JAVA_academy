package project01;

public class Member {
	String name2;
	String ssn;
	String phone;
	
	String user;
	String userNum;
	String pNum;
	int balance;
	
	@Override
	public String toString() {
		return "Member [user=" + user + ", userNum=" + userNum + ", pNum=" + pNum + "]";
	}

	public Member(String user, String userNum, String pNum) {
		super();
		this.user = user;
		this.userNum = userNum;
		this.pNum = pNum;
	}
	
	

	public Member(int balance) {
		super();
		this.balance = balance;
	}

	public Member() {
		
	}
		
}
