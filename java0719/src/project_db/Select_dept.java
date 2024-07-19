package project_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Select_dept {

	public static void main(String[] args) {
		String dept = "select * from dept";
		
		String URL = "jdbc:mysql://192.168.56.1:3306/spring5fs";
		Connection con = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery(dept);
			
			while(rs1.next()) {
				System.out.print(rs1.getString(1) + ", ");
				System.out.print(rs1.getString(2) + ", ");
				System.out.println(rs1.getString(3));
			}
	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}

