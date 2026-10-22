package principal.logic;

import java.awt.*;

import objects.bird.Bird;
import objects.pipe.Pipe;
import principal.GameConstants;
import principal.utils.LoadFile;

public class GameLogic {

	private final Font fontGameOver;

	private final Bird bird;
	private final PipeLogic pipeLogic;

	public int score;
	
	public GameLogic() {
		this.pipeLogic = new PipeLogic();
		bird = new Bird(pipeLogic.mostCloseToBird(Bird.INITIAL_X));
		this.score = bird.getScore();

		fontGameOver = LoadFile.loadFont("resources/font/YellowBanana.otf", 102f);

	}
	
	public void update() {
		updateBird();
		this.pipeLogic.update();
		this.score = bird.getScore();
	}

	private void updateBird(){
		bird.update();

		if(bird.getPipe() == null){
			bird.setPipe(pipeLogic.mostCloseToBird(bird.getX()));
			bird.updateScore();
		}

	}

	public void resetGame(){
		pipeLogic.resetPipes();
		bird.resetBird();
		bird.setPipe(pipeLogic.mostCloseToBird(bird.getX()));
	}
	
	public void paint(Graphics2D g2) {
		this.pipeLogic.paint(g2);
	}

	public void paintBird(Graphics2D g2){
		bird.paint(g2);
	}

	public void paintGameOver(Graphics2D g2){
		g2.setColor(Color.RED);
		g2.setFont(fontGameOver);
		g2.drawString("GAME OVER", (float)(GameConstants.WIDTH/2) - 102f * 3, (float)GameConstants.HEIGHT/2);
	}
	
	public Bird getBird() {
		return this.bird;
	}

	public boolean inGame(){
		return bird.isAlive();
	}

}
