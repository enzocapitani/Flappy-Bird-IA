package objects.bird;

import java.awt.Color;
import java.awt.Graphics2D;

import objects.ObjectInterface;

public class Bird implements ObjectInterface{
	
	private int x, y, size,
				vel;
	
	public Bird() {
 		this.x = 150;
		this.y = 300;
		this.size = BirdConstant.SIZE;
		this.vel = -10;
	}
	
	@Override 
	public void update() {
		
		this.vel += BirdConstant.GRAVITY_FORCE;
		
		if(vel > 30) vel = 30;
		
		this.y += vel/2;
	}
	
	public void jump() {
		this.vel = BirdConstant.JUMP_FORCE;  
	}
	
	@Override 
	public void paint(Graphics2D g) {
		Graphics2D bird = (Graphics2D) g.create();
		
		bird.setColor(Color.GREEN);   
		bird.fillRect(x, y, size, size);
		
		bird.dispose();
	}
	
}
