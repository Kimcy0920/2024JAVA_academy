package java0722;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcEx7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		Statement stmt = null;
		
//		String sql = "select * from dept where loc = '서울'";
		
		System.out.print("지역 입력: ");
		String str = scan.nextLine();
//		String sql = "select * from dept where loc = '" + str + "'"; 
		String sql = String.format("select * from dept where loc = '%s'", str);
		// format(printf문 같은 형태) 더 간편해짐.
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql); // ResultSet: select문에서 어떤걸 찾을지 모를때 사용
			
			if (!rs.next()) {
				System.out.println("입력한 지역에는 부서가 없습니다.");
			}
			
			while(rs.next()) { // rs.next(); boolean타입으로 리턴, 참이면 다음
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.printf("%d, %s, %s\n", deptno, dname, loc);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
