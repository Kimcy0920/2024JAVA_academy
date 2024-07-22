package java0722;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcEx3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int deptno = 0;
		String dname = "";
		String loc = "";
		
		System.out.print("DEPTNO 입력: ");
		deptno = Integer.parseInt(scan.nextLine());
		System.out.print("DNAME 입력: ");
		dname = scan.nextLine();
		System.out.print("LOC 입력: ");
		loc = scan.nextLine();
		
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		Statement stmt = null;
		String sql ="insert into dept(deptno, dname, loc) values"
				+ "(" + deptno + "," + "'" + dname + "'," + "'" + loc + "')";

//		String sql ="insert into dept(deptno, dname, loc) values (1001, '총무부', '인천'), (1002, '인사부', '일산'), (1003, '회계부', '서울')";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("쿼리성공!!");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
