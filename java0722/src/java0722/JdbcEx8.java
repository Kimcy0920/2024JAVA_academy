package java0722;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxSql.StmtExecute;

public class JdbcEx8 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		Statement stmt = null;
//		String sql ="select max(deptno) from dept"; // 마지막 부서번호 찾기
		String sql ="select max(deptno) as max from dept"; // as 별명 붙이기
		
		String dname = "";
		String loc = "";
		
		System.out.print("DNAME 입력: ");
		dname = scan.nextLine();
		System.out.print("LOC 입력: ");
		loc = scan.nextLine();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql); // ResultSet: select문에서 어떤걸 찾을지 모를때 사용

			rs.next(); // 다음다음
//			int maxNo = rs.getInt(1); // maxNo에 마지막 부서번호 넣기
			int maxNo = rs.getInt("max"); // as로 max로 별명을 지었기 때문에 max로도 가능
			System.out.println(maxNo); // 출력
			
			sql = String.format("insert into dept(deptno, dname, loc) values"
					+ "(%s, '%s', '%s')", maxNo+1, dname, loc); // insert문으로 데이터 입력, 부서번호는 마지막 번호(+1)로 함

			int res = stmt.executeUpdate(sql);
			System.out.println(res + "건을 입력");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
