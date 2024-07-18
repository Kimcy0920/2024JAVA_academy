package project2;

import java.io.Serializable;

public class Member implements Serializable {
	private String name;
	private String ssn;   // 주민번호 6자리 패스워드
	private String phone;
	private int balance; // 접근제한으로 인해 get, set 생성해야함
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", ssn=" + ssn + ", phone=" + phone + ", balance=" + balance + "]";
	}
	
	//  입금
	public void deposit(int deposit) {
		if(deposit <= 0) {
			return;
		}
		balance += deposit;
	}
	
	// 출금
	public void withdraw(int withdraw) {
		if(withdraw > balance) {
			return;
		}
		
		if(withdraw <= 0) {
			return;
		}
		balance -= withdraw;
	}
	
	public Member(String name, String ssn, String phone) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
	}
	
	public Member() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
