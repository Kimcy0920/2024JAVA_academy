package project_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Select_emp {

	public static void main(String[] args) {
		String emp = "select * from emp";
		
		String URL = "jdbc:mysql://192.168.56.1:3306/spring5fs";
		Connection con = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			stmt = con.createStatement();
			ResultSet rs2 = stmt.executeQuery(emp);

			while(rs2.next()) {
			System.out.print(rs2.getString(1) + ", ");
			System.out.print(rs2.getString(2) + ", ");
			System.out.print(rs2.getString(3) + ", ");
			System.out.print(rs2.getString(4) + ", ");
			System.out.print(rs2.getString(5) + ", ");
			System.out.print(rs2.getString(6) + ", ");
			System.out.print(rs2.getString(7) + ", ");
			System.out.println(rs2.getString(8));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}

