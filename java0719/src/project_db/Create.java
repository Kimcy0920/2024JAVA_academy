package project_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Create {

	public static void main(String[] args) { // CREATE문
		String dept = "CREATE TABLE dept" +
					"(DEPTNO int(11)," +
					"DNAME varchar(14)," +
					"LOC varchar(13))";
		
		String emp = "CREATE TABLE emp" +
				"(EMPNO int(11) not null," +
				"ENAME varchar(10)," +
				"JOB varchar(9)," +
				"MGR int(11)," +
				"HIREDATE date," +
				"SAL int(11)," +
				"COMM int(11)," +
				"DEPTNO int(11))";
		
		String URL = "jdbc:mysql://192.168.56.1:3306/spring5fs";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 1. 드라이버 유무 확인
			con = DriverManager.getConnection(URL, "spring5", "spring5"); // 2. 드라이버 접속
			stmt = con.createStatement(); // 3. 명령문 보내기
			stmt.executeUpdate(dept); // 4. 명령문 실행
			stmt.executeUpdate(emp);
			System.out.println("[테이블 생성]");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}

/*
 * CRUD
 * Create(Insert문), Read(Select문), Update, Delete 
*/
