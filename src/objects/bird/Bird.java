package objects.bird;

import java.awt.Color;
import java.awt.Graphics2D;

import objects.ObjectInterface;
import principal.GameConstants;

public class Bird implements ObjectInterface{
	
	public static final int GRAVITY_FORCE = 1;

	public static final int JUMP_FORCE = -20;

	public static final double SIZE = GameConstants.HEIGHT * 0.04;

	public static final int INITIAL_X = (int)(GameConstants.WIDHT * 0.25);

	public static final int INITIAL_Y = (int)(GameConstants.HEIGHT * 0.4);

	private int x, y, size,
				vel;
	
	public Bird() {
 		this.x = Bird.INITIAL_X;
		this.y = Bird.INITIAL_Y;
		this.size = (int) Bird.SIZE;
		System.out.println(size);
		this.vel = -10;
	}
	
	@Override 
	public void update() {
		
		this.vel += Bird.GRAVITY_FORCE;
		
		if(vel > 30) vel = 30;
		
		this.y += vel/2;
	}
	
	public void jump() {
		this.vel = Bird.JUMP_FORCE;  
	}
	
	@Override 
	public void paint(Graphics2D g) {
		Graphics2D bird = (Graphics2D) g.create();
		
		bird.setColor(Color.GREEN);   
		bird.fillRect(x, y, size, size);
		
		bird.dispose();
	}
	
}
