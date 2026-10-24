package principal;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow {
	JFrame frame;
	
	public GameWindow() {
		this.frame = new JFrame();
	}
	
	public void showWindow(JPanel panel) {
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.add(panel);
		this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
		
		panel.requestFocus(true);
	}
	
}
