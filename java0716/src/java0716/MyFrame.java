package java0716;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame { // extends, JFrame으로부터 상속받음 -> MyFrame
	
	JButton jb = new JButton("테스트");
	
	public MyFrame() {
		
		Container con = this.getContentPane();
		con.setLayout(null);
		con.add(jb);
		jb.setLocation(200,  300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("너는 전혀 스윙을 하고 있지 않아.");
		this.setLocation(700, 300);
		this.setSize(500, 300);
		this.setVisible(true); // this.
		// JFrame
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
