package java0724;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex2 {
	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into dept(deptno, dname, loc) values (?, ?, ?)";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩!");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			System.out.println("Mysql 접속 성공!");
			pstmt = conn.prepareStatement(sql); // sql 명령어를 pstmt에 넣음
			pstmt.setInt(1, 1007);
			pstmt.setString(2, "아비부");
			pstmt.setString(3, "전주");
//			pstmt.executeUpdate(); // pstmt를 업데이트
			int ret = pstmt.executeUpdate(); // 리턴값, ret에 pstmt 값 넣기
			System.out.println(ret + "건 insert 성공");
		} catch (ClassNotFoundException | SQLException e) {
			// Class.forName이 없으면 ClassNotFoundException 발생
			e.printStackTrace();
		}
	}
}
