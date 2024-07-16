package project2swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// import Project1_2.Member;

public class MyFrame extends JFrame { // extends, JFrame으로부터 상속받는 MyFrame 클래스
	JLabel lb1 = new JLabel("아이디");
	JTextField jt1 = new JTextField();
	
	JLabel lb2 = new JLabel("SSN");
	JTextField jt2 = new JTextField();
	
	JLabel lb3 = new JLabel("전화번호");
	JTextField jt3 = new JTextField();
	
	JTextArea ta = new JTextArea();
	
	JButton jb1 = new JButton("로그인");
	JButton jb2 = new JButton("회원가입");
	JButton jb3 = new JButton("예금");
	JButton jb4 = new JButton("출금");
	JButton jb5 = new JButton("잔고");
	
	List<Member> list; // 전역변수 위치(필드)로 변경
	Member member;
/* 
*/
	
	public MyFrame() { // 생성자 맨 윗줄, 시작지점 project1코드 붙여넣음
		
//		List<Member> list = null; // list가 생성자의 지역변수가 됨
		try (FileInputStream fis = new FileInputStream("c:\\temp\\members.dat");
	             ObjectInputStream ois = new ObjectInputStream(fis)) {
			
			Member[] list2 = (Member[]) ois.readObject();
			list = new ArrayList<>(Arrays.asList(list2));
		
			System.out.println("파일에서 객체를 가져왔습니다.");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		for (Member member : list) {
			System.out.println(member);
		}
		System.out.println("총회원수: " + list.size());
//		Member member = null; // member가 생성자의 지역변수가 됨
		
		Container con = this.getContentPane();
		con.setLayout(null);
		
		con.add(lb1); // con = container
		lb1.setLocation(20, 50); // lb1 위치
		lb1.setSize(100, 30); // lb1 크기
		
		con.add(jt1);
		jt1.setLocation(70, 50);
		jt1.setSize(100, 30);
		
		con.add(lb2);
		lb2.setLocation(220, 50);
		lb2.setSize(100, 30);
		
		con.add(jt2);
		jt2.setLocation(270, 50);
		jt2.setSize(100, 30);
		
		con.add(lb3);
		lb3.setLocation(420, 50);
		lb3.setSize(100, 30);
		
		con.add(jt3);
		jt3.setLocation(470, 50);
		jt3.setSize(100, 30);
		
		con.add(ta);
		ta.setLocation(20, 120);
		ta.setSize(830, 200);
		
		con.add(jb1);
		jb1.setLocation(20,  350);
		jb1.setSize(100, 30);
		jb1.addActionListener(new MyListener()); // 로그인 처리
		
		con.add(jb2);
		jb2.setLocation(120,  350);
		jb2.setSize(100, 30);
		
		con.add(jb3);
		jb3.setLocation(550,  350);
		jb3.setSize(100, 30);
		
		con.add(jb4);
		jb4.setLocation(650,  350);
		jb4.setSize(100, 30);
		
		con.add(jb5);
		jb5.setLocation(750,  350);
		jb5.setSize(100, 30);
		
		this.setTitle("너는 전혀 스윙을 하고 있지 않아.");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(700, 300);
		this.setSize(900, 500);
		this.setVisible(true); // this.
		// JFrame
	}
	class MyListener implements ActionListener { // MyFrame 안에 MyListener 클래스를 넣음 (중첩클래스 or inner클래스)
			@Override							 // 일종의 메서드 역할, 이벤트를 처리함, p.428 참고
			public void actionPerformed(ActionEvent e) {
				// jt1 아이디입력, jt2 패스워드 입력
				String name = jt1.getText();
				String strPassword = jt2.getText();

				int find = -1;
				
				for (Member member2 : list) {
					if(member2.getName().equals(name) && member2.getSsn().equals(strPassword)) {
						member = member2;
						System.out.println("로그인 성공");
						break;
					}
				}
			}
		}

	
	public static void main(String[] args) {
		new MyFrame(); // 생성자 호출
	}
}
