package java0724;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex3 {
	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select deptno, dname, loc from dept where loc like ?";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩!");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			System.out.println("Mysql 접속 성공!");
			pstmt = conn.prepareStatement(sql); // sql 명령어를 pstmt에 넣음
			pstmt.setString(1, "성남");
			ResultSet rs = pstmt.executeQuery(); // line24 전에 where문에 넣을 pstmt 코드를 넣어야함
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.printf("%d, %s, %s\n", deptno, dname, loc);
			}
//			pstmt.executeUpdate(); // pstmt를 업데이트
		} catch (ClassNotFoundException | SQLException e) {
			// Class.forName이 없으면 ClassNotFoundException 발생
			e.printStackTrace();
		}
	}
}
