package java0719;

// throws ClassNotFoundException 예외 회피

public class Ex1 {
	public static void main(String[] args) { 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Class.forName : 이 클래스가 있는지 없는지 유무 파악
			System.out.println("Mysql Driver Loding...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
}
/*
 *  자바는 패키지 내에 데이터베이스는 외부
 *  JDBC는 서로 다른데에 위치한 두 가지를 연결시키는 역할
 */