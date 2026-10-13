package principal.logic;

import java.awt.Graphics2D;

import objects.bird.Bird;

public class GameLogic {

	private Bird bird;
	private PipeLogic pipeLogic;
	
	public GameLogic() {
		bird = new Bird();
		this.pipeLogic = new PipeLogic();
	}
	
	public void update() {
		this.bird.update(pipeLogic.mostCloseToBird(this.bird));
		this.pipeLogic.update();
	}
	
	public void paint(Graphics2D g2) {
		bird.paint(g2);
		this.pipeLogic.paint(g2);
	}
	
	public Bird getBird() {
		return this.bird;
	}
	
}
