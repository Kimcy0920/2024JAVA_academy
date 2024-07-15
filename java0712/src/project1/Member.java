package project1;

public class Member {
	String user; // 아이디
	String userNum; // 주민번호 앞 6자리
	String pNum; // 전화번호
	int balance;
	@Override
	public String toString() {
		return "Member [user=" + user + ", userNum=" + userNum + ", pNum=" + pNum + ", balance=" + balance + "]";
	}
	public Member(String user, String userNum, String pNum) {
		super();
		this.user = user;
		this.userNum = userNum;
		this.pNum = pNum;
	}
	
	public Member() {}
}
