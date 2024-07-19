package java0719;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Ex3 {

	public static void main(String[] args) { // CREATE문
		String createString = "CREATE TABLE customer" +
						"(customer_id char(6) not null primary key," +
						"customer_name varchar(15) not null," +
						"customer_tel varchar(13)," +
						"customer_addr varchar(20))";
		
		String URL = "jdbc:mysql://192.168.56.1:3306/spring5fs";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 1. 드라이버 유무 확인
			con = DriverManager.getConnection(URL, "spring5", "spring5"); // 2. 드라이버 접속
			System.out.println("Mysql 접속");
			stmt = con.createStatement(); // 3. 명령문 보내기
			stmt.executeUpdate(createString); // 4. 명령문 실행
			System.out.println("테이블 생성");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}

/*
 * CRUD
 * Create(Insert문), Read(Select문), Update, Delete 
*/
