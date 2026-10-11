package principal.logic;

import java.awt.Graphics2D;

import objects.bird.Bird;

public class GameLogic {

	private Bird bird;
	
	public GameLogic() {
		bird = new Bird();
	}
	
	public void update() {
		this.bird.update();
	}
	
	public void paint(Graphics2D g2) {
		bird.paint(g2);
	}
	
	public Bird getBird() {
		return this.bird;
	}
	
}
