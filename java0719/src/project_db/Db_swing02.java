package project_db;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Db_swing02 extends JFrame {

	JLabel la = new JLabel("Enter your SQL SELECT statement");
	JButton btn = new JButton("ENTER");
	JTextField text = new JTextField(20);
	
	JPanel table_p = new JPanel();
	JPanel btn_p = new JPanel();
	
	JTextArea table_a = new JTextArea(25, 60);
	
	Db_swing02() {
		
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		
		con.add(table_p, BorderLayout.SOUTH);
		table_p.add(table_a);
		
		con.add(btn_p, BorderLayout.NORTH);
		btn_p.setLayout(new FlowLayout());
		btn_p.add(la); btn_p.add(text); btn_p.add(btn);
		
		btn.addActionListener(new Btn_ac());
		
		this.setTitle("SELECT_TABLE");
		this.setBounds(1000, 200, 700, 500);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class Btn_ac implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String url = "jdbc:mysql://localhost:3306/spring5fs";
	        String user = "root";
	        String password = "1234";
	        String sql = text.getText();
	        
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            table_a.append("MySQL JDBC driver loaded successfully.\n");

	            Connection conn = DriverManager.getConnection(url, user, password);
	            table_a.append("Connected to the MySQL server successfully.\n\n");

	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);

	            ResultSetMetaData rsmd = rs.getMetaData();
	            int columnsNumber = rsmd.getColumnCount();
	            while (rs.next()) {
	                for (int i = 1; i <= columnsNumber; i++) {
	                    if (i > 1) table_a.append(",  ");
	                    String columnValue = rs.getString(i);
	                    table_a.append(rsmd.getColumnName(i) + ": " + columnValue);
	                }
	                table_a.append("\n");
	            }

	            rs.close();
	            stmt.close();
	            conn.close();
	        } catch (ClassNotFoundException e2) {
	        	table_a.setText("MySQL JDBC Driver not found.");
	            e2.printStackTrace();
	        } catch (SQLException e2) {
	        	table_a.setText("Database connection or query execution failed.");
	            e2.printStackTrace();
	        }
			
		}
		
	}
	
	
	public static void main(String[] args) {
		new Db_swing02();
	}
}
