package java0716;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListener implements ActionListener {
// 표준안(메서드명)
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("클릭!");
	}
}
