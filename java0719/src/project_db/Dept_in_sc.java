package project_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Dept_in_sc {

	public static void main(String[] args) { // INSERT문
		Scanner scan = new Scanner(System.in);
		
		int no = 0;
		String name = "";
		String location = "";
		
		System.out.println("[데이터 입력]");
		System.out.print("DEPTNO: ");
		no = Integer.parseInt(scan.nextLine());
		System.out.print("DNAME: ");
		name = scan.nextLine();
		System.out.print("LOC: ");
		location = scan.nextLine();
		
		String dept = "INSERT INTO dept VALUES" +
				"(" + no + "," + "'" + name + "', " + "'" + location + "')";
		
		String URL = "jdbc:mysql://192.168.56.1:3306/spring5fs";
		Connection con = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			stmt = con.createStatement();
			int num = stmt.executeUpdate(dept);		
			System.out.println("[테이블에 삽입] " + num);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}

/*
 * CRUD
 * Create(Insert문), Read(Select문), Update, Delete 
*/