package project_db;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Db_swing extends JFrame {
	
	JButton dept_btn = new JButton("DEPT TABLE");
	JButton emp_btn = new JButton("EMP TABLE");
	
	JPanel table_panel = new JPanel();
	JPanel btn_panel = new JPanel();
	
	JTextArea table_area = new JTextArea(25, 60);
	
	Db_swing() {
		
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		
		con.add(table_panel, BorderLayout.NORTH);
		table_panel.add(table_area);
		
		con.add(btn_panel, BorderLayout.SOUTH);
		btn_panel.setLayout(new FlowLayout());
		btn_panel.add(dept_btn); btn_panel.add(emp_btn);
		
		dept_btn.addActionListener(new Dept_Listener());
		emp_btn.addActionListener(new Emp_Listener());
		
		this.setTitle("DEPT&EMP_TABLE");
		this.setBounds(1000, 200, 700, 500);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class Dept_Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

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
					String no = (rs1.getString(1) + ", ");
					String name = (rs1.getString(2) + ", ");
					String location = (rs1.getString(3));
					
					table_area.append(no + name + location + "\n");
				}
				table_area.append("\n");
				
		
			} catch (ClassNotFoundException | SQLException e2) {
				e2.printStackTrace();
			}
			
		}
		
	}
	class Emp_Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
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
					String epno = (rs2.getString(1) + ", ");
					String name = (rs2.getString(2) + ", ");
					String job = (rs2.getString(3) + ", ");
					String mgr = (rs2.getString(4) + ", ");
					String hiredate = (rs2.getString(5) + ", ");
					String sal = (rs2.getString(6) + ", ");
					String comm = (rs2.getString(7) + ", ");
					String dpno = (rs2.getString(8));
						
					table_area.append(epno + name + job + mgr + hiredate + sal + comm + dpno + "\n");
					
				}
				
			} catch (ClassNotFoundException | SQLException e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		new Db_swing();
	}

}

// Button 2개, TextArea 1개