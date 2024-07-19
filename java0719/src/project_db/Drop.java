package project_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Drop {

	public static void main(String[] args) {
		String dept = "drop table dept";
		String emp = "drop table emp";
		
		String URL = "jdbc:mysql://192.168.56.1:3306/spring5fs";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			stmt = con.createStatement();
			int num1 = stmt.executeUpdate(dept);
			int num2 = stmt.executeUpdate(emp);
			System.out.println("[테이블 삭제] " + num1);
			System.out.println("[테이블 삭제] " + num2);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}

/*
 * CRUD
 * Create(Insert문), Read(Select문), Update, Delete 
*/
