package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import objects.bird.Bird;
import principal.logic.GameLogic;

public class BirdKeyListener implements KeyListener {

	Bird bird;
	GameLogic gameLogic;
	
	public BirdKeyListener(GameLogic gameLogic) {
		this.gameLogic = gameLogic;
		bird = gameLogic.getBird();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE && gameLogic.inGame())
			this.bird.jump();

		if(e.getKeyCode() == KeyEvent.VK_R && !gameLogic.inGame())
			gameLogic.resetGame();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
