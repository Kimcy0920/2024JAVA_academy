package java0718;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 

public class Cal3 extends JFrame{
	JTextField num1, num2;
	JButton plus, minus, multiply, divide;
	JLabel label02;

	public Cal3() {
		
		setTitle("계산기 화면");
		setSize(300, 250);	

		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 300,40);
		add(titlePanel);
		JLabel title = new JLabel("계산기", JLabel.CENTER);
		title.setFont(new Font("함초롱돋움", Font.BOLD, 20));
		titlePanel.add(title);	

		
			
		JPanel numPanel = new JPanel();		
		numPanel.setBounds(0, 40, 300, 40);
		add(numPanel);		
		num1 = new JTextField(5);	
		numPanel.add(num1);
		num2 = new JTextField(5);
		numPanel.add(num2);
	
		
		
		JPanel btPanel01 = new JPanel();	
		btPanel01.setBounds(0, 80, 300, 40);
		add(btPanel01);		
		plus = new JButton("+");		
		btPanel01.add(plus);
		minus = new JButton("-");
		btPanel01.add(minus);
		
		
		JPanel btPanel02 = new JPanel();	
		btPanel02.setBounds(0, 120, 300, 40);
		add(btPanel02);		
		multiply = new JButton("*");	
		btPanel02.add(multiply);
		divide = new JButton("/");
		btPanel02.add(divide);
				
		
		JPanel resultPanel = new JPanel();
		resultPanel.setBounds(0, 160, 300, 40);
		add(resultPanel);
		JLabel label01 = new JLabel("계산결과 : ");
		label02 = new JLabel("0");
		resultPanel.add(label01);
		resultPanel.add(label02);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		
		// 3. 인터페이스 익명의 객체생성
		// 짜면서 생각나는데로 작성해서 직관적임.
		plus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double n1 = Double.parseDouble(num1.getText());
				double n2 = Double.parseDouble(num2.getText());
				label02.setText(String.valueOf(n1+n2));
			}
		});
		minus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double n1 = Double.parseDouble(num1.getText());
				double n2 = Double.parseDouble(num2.getText());
				label02.setText(String.valueOf(n1-n2));
			}
		});
		multiply.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double n1 = Double.parseDouble(num1.getText());
				double n2 = Double.parseDouble(num2.getText());
				label02.setText(String.valueOf(n1*n2));
			}
		});
		divide.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double n1 = Double.parseDouble(num1.getText());
				double n2 = Double.parseDouble(num2.getText());
				label02.setText(String.valueOf(n1/n2));
			}
		});
		
	}
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//		double result = 0.0;
//		double n1 = Double.parseDouble(num1.getText());
//		double n2 = Double.parseDouble(num2.getText());
//		
//		switch(e.getActionCommand()) {
//		case "+": result = n1 + n2; break;
//		case "-": result = n1 - n2; break;
//		case "*": result = n1 * n2; break;
//		case "/": result = n1 / n2; break;
//		}
//		
////		if(e.getSource() == plus) {
////			result = n1 + n2;
////		} else if (e.getSource() == minus) {
////			result = n1 - n2;
////		} else if (e.getSource() == multiply) {
////			result = n1 * n2;
////		} else if (e.getSource() == divide) {
////			result = n1 / n2;
////		}
//		label02.setText(String.valueOf(result)); // valueOf
//		
//	}

	
	public static void main(String[] args) {  
		new Cal3();
	}

}