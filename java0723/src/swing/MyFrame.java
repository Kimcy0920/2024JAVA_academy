package swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
	
	String[] stand = {"stand.gif"};
	String[] walk = {"walk1.gif", "walk2.gif"};
	String[] run = {"run1.gif", "run2.gif", "run3.gif"};
	
	PATH p = PATH.STAND;
	String[] path = stand;
	
	MyFrame() {
		this.setLayout(new BorderLayout()); // 전체 레이아웃
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Field field = new Field(); // field 객체 생성
		Control control = new Control();
		this.add(field, BorderLayout.CENTER); // 그림판에 add, JFrame 상속받은 panel에 field 레이아웃 설정
		this.add(control, BorderLayout.SOUTH); // JFrame 상속받은 panel에 Control 레이아웃 설정
		this.setBounds(1200, 100, 500, 500);
		this.setVisible(true);
		
		// 여기에 Thread를 객체생성하여 start()메소드 호출하기
		Thread thread = new Thread(field);
		thread.start();
	}
	
	private class Field extends JPanel implements Runnable { // 스레드 인터페이스 구현		
//		JLabel lb1 = new JLabel();
		JLabel lb1;
		Field() { // 생성자
			this.setLayout(new BorderLayout());
			lb1 = new JLabel();
			lb1.setIcon(new ImageIcon("./src/stand.gif"));
			this.add(lb1, BorderLayout.CENTER);
		} // 처음 실행 시 상태 stand
		
		@Override
		public void run() {
			while(true) {
				switch(p) {
				case STAND:
					path = stand;
					break;
				case WALK:
					path = walk;
					break;
				case RUN:
					path = run;
					break;
				default:
					path = stand;
				}
					for(int i=0; i<path.length; i++) {
						lb1.setIcon(new ImageIcon("./src/" + path[i]));
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {}
					}
			}
				
		}
	}

	private class Control extends JPanel implements ActionListener {
		private JButton standingBtn, walkingBtn, runningBtn;
		public Control() {
			this.setLayout(new FlowLayout()); // Panel
			
			standingBtn = new JButton("Standing");
			walkingBtn = new JButton("Walking");
			runningBtn = new JButton("running");
			
			standingBtn.addActionListener(this);
			walkingBtn.addActionListener(this);
			runningBtn.addActionListener(this);
			
			this.add(standingBtn); // Panel에 버튼 붙이기
			this.add(walkingBtn);
			this.add(runningBtn);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == standingBtn) {
				p = PATH.STAND;
			} else if (e.getSource() == walkingBtn) {
				p = PATH.WALK;
			} else if (e.getSource() == runningBtn) {
				p = PATH.RUN;
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
	
}
