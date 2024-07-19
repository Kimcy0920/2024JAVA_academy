package java0719;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Ex6 {

	public static void main(String[] args) {
		String sql = "select * from customer";
		
		String URL = "jdbc:mysql://192.168.56.1:3306/spring5fs";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			System.out.println("[Mysql 접속]");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql); // 자료를 가져오는 메모리의 위치 정보
												   // executeQuery 질의문
			
			while(rs.next()) { //
//				System.out.print(rs.getString("customer_id") + ", "); //
//				System.out.println(rs.getString("customer_name")); // 컬럼명으로 읽어옴
				System.out.print(rs.getString(1) + ", "); // CREATE문에서 char, varchar 문자열로 저장했으므로 getString으로 읽어옴
				System.out.println(rs.getString(2)); // 번호로도 읽을 수 있음
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}

/*
* CRUD
* Create(Insert문), Read(Select문), Update, Delete 		
*/
