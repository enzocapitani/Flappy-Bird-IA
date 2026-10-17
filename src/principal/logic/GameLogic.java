package principal.logic;

import java.awt.*;

import objects.bird.Bird;
import principal.GameConstants;
import principal.utils.LoadFile;

public class GameLogic {

	private Font fontGameOver;

	private Bird bird;
	private PipeLogic pipeLogic;

	public int score;
	
	public GameLogic() {
		bird = new Bird();
		this.pipeLogic = new PipeLogic();
		this.score = bird.getScore();

		fontGameOver = LoadFile.loadFont("resources/font/YellowBanana.otf", 102f);

	}
	
	public void update() {
		this.bird.update(pipeLogic.mostCloseToBird(this.bird));
		this.pipeLogic.update();
		this.score = bird.getScore();
	}

	public void resetGame(){
		pipeLogic.resetPipes();
		bird.resetBird();

	}
	
	public void paint(Graphics2D g2) {
		bird.paint(g2);
		this.pipeLogic.paint(g2);
	}

	public void paintGameOver(Graphics2D g2){
		g2.setColor(Color.RED);
		g2.setFont(fontGameOver);
		g2.drawString("GAME OVER", (float)(GameConstants.WIDHT/2) - 102f * 3, (float)GameConstants.HEIGHT/2);
	}
	
	public Bird getBird() {
		return this.bird;
	}

	public boolean inGame(){
		return bird.isAlive();
	}

}
