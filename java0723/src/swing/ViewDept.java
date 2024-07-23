package swing;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ViewDept extends JFrame {
	
	JTextField tfield = new JTextField(20);
	JTextArea tarea = new JTextArea(10, 40);
	JButton btn = new JButton("조회");
	Connection conn;
	Statement stmt;
	// 커넥션, 스테이트먼트를 필드로 올림
	JFrame jf; // jframe을 jf로 필드값.
	
	ViewDept() {
		jf = this; // this는 jf를 가르키게 함
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			stmt = conn.createStatement();
		} catch (ClassNotFoundException | SQLException e2) {
			e2.printStackTrace();
		}
		// 접속 코드
		
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		
		JPanel pan1 = new JPanel();
		pan1.setLayout(new FlowLayout());
		pan1.add(tfield); pan1.add(btn);
		con.add(pan1, BorderLayout.NORTH);
		
		JPanel pan2 = new JPanel();
		pan2.setLayout(new FlowLayout());
		pan2.add(tarea);
		con.add(pan2, BorderLayout.CENTER);
		
		this.setTitle("view dept table");
		this.setBounds(1200, 200, 500, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addActionListener((e)-> { // 내부 클래스 - 익명 객체
				String str = tfield.getText();
				
				try {

					ResultSet rs = stmt.executeQuery(str); // 쿼리 입력받음

		            ResultSetMetaData rsmd = rs.getMetaData();
		            int columnsNumber = rsmd.getColumnCount();
		            tarea.setText("");
		            while (rs.next()) {
		                for (int i = 1; i <= columnsNumber; i++) {
		                    if (i > 1) tarea.append(",  ");
		                    String columnValue = rs.getString(i);
		                    tarea.append(rsmd.getColumnName(i) + ": " + columnValue);
		                }
		                tarea.append("\n");
		            }
					
				} catch (SQLException e3) {
					JOptionPane.showMessageDialog(jf, "해당 정보는 없습니다.", "정보", JOptionPane.ERROR_MESSAGE);
				}
			
		});
	}
	
	public static void main(String[] args) {
		new ViewDept();
	}
	
}	
