package project2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	JLabel la1 = new JLabel("아이디");
	JTextField tf1 = new JTextField(7);
	
	JLabel la2 = new JLabel("SSN");
	JTextField tf2 = new JTextField(7);
	
	JLabel la3 = new JLabel("전화번호");
	JTextField tf3 = new JTextField(14);
	
	JTextArea ta = new JTextArea(15, 60);
	
	JButton jb1 = new JButton("로그인");
	JButton jb2 = new JButton("회원가입");
	
	JTextField tf4 = new JTextField(7);
	JButton jb3 = new JButton("예금");
	JButton jb4 = new JButton("출금");
	JButton jb5 = new JButton("잔고");
	
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	
	List<Member> list;
	Member member;
	
	MyFrame() {
		
		try (FileInputStream fis = new FileInputStream("c:\\temp\\members.dat");
	             ObjectInputStream ois = new ObjectInputStream(fis)) {
			
			Member[] list2 = (Member[]) ois.readObject();
			list = new ArrayList<>(Arrays.asList(list2));
		
			ta.setText("파일에서 객체를 가져왔습니다.");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		for (Member member : list) {
			ta.append("\n회원정보: " + member);
		}
		ta.append("\n총 회원수: " + list.size());
		// 처음
		
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout(10, 10));
		
		con.add(jp1, BorderLayout.NORTH);
		jp1.setLayout(new FlowLayout());
		jp1.add(la1); jp1.add(tf1);
		jp1.add(la2); jp1.add(tf2);
		jp1.add(la3); jp1.add(tf3);

		con.add(jp2, BorderLayout.CENTER);
		jp2.setLayout(new FlowLayout());
		jp2.add(ta);
		
		con.add(jp3, BorderLayout.SOUTH);
		jp3.setLayout(new FlowLayout());
		jp3.add(jb1); jp3.add(jb2); jp3.add(tf4); 
		jp3.add(jb3); jp3.add(jb4); jp3.add(jb5);
		
		
		jb1.addActionListener(new MyListenerLogin()); // 로그인
		jb2.addActionListener(new MyListenerSign()); // 회원가입
		jb3.addActionListener(new MyListenerIn()); // 예금
		jb4.addActionListener(new MyListenerOut()); // 출금
		jb5.addActionListener(new MyListenerData()); // 잔고
		
		this.setTitle("MyFrame");
		this.setBounds(1000, 200, 700, 500);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.addWindowListener(new JFrameWindowClosingEventHandler());
		
	}
	class JFrameWindowClosingEventHandler extends WindowAdapter { // 저장
		
		@Override
		public void windowClosing(WindowEvent e) {
			Member[] list2 = list.toArray(new Member[list.size()]);
			try (FileOutputStream fos = new FileOutputStream("c:\\temp\\members.dat");
		             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				
				 oos.writeObject(list2);
		         System.out.println("객체를 파일에 저장했습니다.");
				
				
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			
			JFrame frame = (JFrame)e.getWindow();
			frame.dispose();
			System.out.println("windowClosing()");
		}
	}
	
	class MyListenerLogin implements ActionListener { // 로그인
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = tf1.getText();
			String strPassword = tf2.getText();

			int find = -1;
			
			for (Member member2 : list) {
				if(member2.getName().equals(name) && member2.getSsn().equals(strPassword)) {
					member = member2;
					ta.setText("로그인 성공");
					break;
				}
			}
			ta.append("\n[회원정보] \n" + member); // 수정
			
		}
		
	}
	class MyListenerSign implements ActionListener { // 회원가입
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String name2 = tf1.getText();
			String ssn = tf2.getText();
			String tel = tf3.getText();
			
			list.add(new Member(name2, ssn, tel));
			ta.setText("회원가입 완료");
			ta.append("\n[입력된 내용]" + "\n1. 이름: " + name2 + "\n2. 주민번호 앞 6자리: " + ssn + "\n3. 전화번호: " + tel);
		}
		
	}
	class MyListenerIn implements ActionListener { // 예금

		@Override
		public void actionPerformed(ActionEvent e) {
			tf4.getText();
			member.deposit(Integer.parseInt(tf4.getText()));
			ta.setText("예금액>  " + member.getBalance() + "원");
		}
		
	}
	class MyListenerOut implements ActionListener { // 출금

		@Override
		public void actionPerformed(ActionEvent e) {
			member.withdraw(Integer.parseInt(tf4.getText()));
			ta.setText("출금액>  " +member.getBalance() + "원");
		}
		
	}
	class MyListenerData implements ActionListener { // 잔고

		@Override
		public void actionPerformed(ActionEvent e) {
			ta.setText("잔고>  " + member.getBalance() + "원");
		}
		
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
