package principal.logic;

import java.awt.Graphics2D;

import objects.bird.Bird;

public class GameLogic {

	private Bird bird;
	private PipeLogic pipeLogic;

	public int score;
	
	public GameLogic() {
		bird = new Bird();
		this.pipeLogic = new PipeLogic();
		this.score = bird.getScore();
	}
	
	public void update() {
		this.bird.update(pipeLogic.mostCloseToBird(this.bird));
		this.pipeLogic.update();
		this.score = bird.getScore();

		if(!this.bird.isAlive()){
			pipeLogic.resetPipes();
			this.bird.resetBird();
		}

	}
	
	public void paint(Graphics2D g2) {
		bird.paint(g2);
		this.pipeLogic.paint(g2);
	}
	
	public Bird getBird() {
		return this.bird;
	}
	
}
