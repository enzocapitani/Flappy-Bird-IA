package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import objects.bird.Bird;

public class BirdKeyListener implements KeyListener {

	Bird bird;
	
	public BirdKeyListener(Bird bird) {
		this.bird = bird;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		this.bird.jump();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
