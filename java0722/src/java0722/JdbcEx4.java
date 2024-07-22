package java0722;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx4 {

	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		Statement stmt = null;
//		String sql ="select * from dept";
		String sql ="select deptno, dname, loc from dept"; // 원래는 칼럼을 일일히 다 써야함
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql); // ResultSet: select문에서 어떤걸 찾을지 모를때 사용

//			System.out.println(rs.getInt("deptno")); // getInt, getString, getDouble
			
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
