package swingjdbc;

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
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		String sql ="select deptno, dname, loc from dept";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			stmt = conn.createStatement();
			tarea.setText("접속됨");
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
		
		
		WinTime winTime = new WinTime(); // 시계코드 객체생성, 실행
		Thread thread = new Thread(winTime); // 스레드 인터페이스
		thread.start();
		con.add(winTime, BorderLayout.SOUTH); // winTime 판넬
		
//		this.setTitle("view dept table");
		this.setBounds(1200, 200, 500, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addActionListener(new ActionListener() { // 내부 클래스 - 익명 객체
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = tfield.getText();
				String sql = String.format("SELECT * FROM dept where loc like '%%%s%%';", str);
				
				try {
					ResultSet rs = stmt.executeQuery(sql); // 1. 코드 반복
					tarea.setText("");
					
//					if(!rs.next()) {
//						JOptionPane.showMessageDialog(jf, "해당 정보는 없습니다.", "정보", JOptionPane.ERROR_MESSAGE);
//						// 익명 객체여서 사용할 수 없으나 jframe을 필드, this로 값을 가져다 쓸수 있게됨
//					}
//					rs = stmt.executeQuery(sql); // 2. 코드 반복
					
					boolean flag = true; // flag 사용
					
					while(rs.next()) {
						flag = false;
						int deptno = rs.getInt("deptno");
						String dname = rs.getString("dname");
						String loc = rs.getString("loc");
						tarea.append(String.format("%d, %s, %s\n", deptno, dname, loc));
						// append는 컴포넌트에 계속 누적됨.
					}
					
					if(flag) {
						JOptionPane.showMessageDialog(jf, "해당 정보는 없습니다.", "정보", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (SQLException e3) {
					e3.printStackTrace();
				}
				
			}
			
			
		});
	}
	
	public static void main(String[] args) {
		new ViewDept();
	}
	
//	class MyPanel extends JPanel implements Runnable {
//		JLabel label;
//		MyPanel() {
//			label = new JLabel();
//			this.add(label);
//		}
//		@Override
//		public void run() {
//			for(;;) {
//				LocalTime localTime = LocalTime.now();
//				String str = String.format("%d : %d : %d\n", localTime.getHour(), localTime.getMinute(), localTime.getSecond());
//				this.label(str);
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
//	}
	
	class WinTime extends JPanel implements Runnable { // 다중상속이 안되기 때문에 Thread를 Runnable 인터페이스로 구현
		JLabel label;
		WinTime() {
			label = new JLabel();
			this.add(label);
		}
		@Override
		public void run() {
			for(;;) {
				LocalTime localTime = LocalTime.now();
				String str = String.format("%d : %d : %d\n", localTime.getHour(), localTime.getMinute(), localTime.getSecond());
				label.setText(str);
				ViewDept.this.setTitle(str);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}	
