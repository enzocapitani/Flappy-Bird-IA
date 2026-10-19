package objects.bird;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import objects.ObjectInterface;
import objects.pipe.Pipe;
import principal.GameConstants;
import principal.utils.LoadFile;
import principal.utils.SpriteColorizer;

public class Bird implements ObjectInterface{

	// ====================== CONSTANTS ====================== 
	
	public static final int GRAVITY_FORCE = 1;

	public static final int JUMP_FORCE = -20;

	public static final int SIZE = (int)(GameConstants.WIDTH * 0.04);

	public static final int INITIAL_X = (int)(GameConstants.WIDTH * 0.25);

	public static final int INITIAL_Y = (int)(GameConstants.HEIGHT * 0.4);

	public static final int INITIAL_VELOCITY = -10;

	private static final double MAX_ANGLE = Math.toRadians(90);
	private static final double MIN_ANGLE = Math.toRadians(-25);

	private static final double ROTATION_SMOOTHING = 0.12;


	// ====================== VARIABLES ======================

	private Pipe pipe;

	private int x, y, size,
				vel, score;

	private boolean alive;

	private double angle;

	private BufferedImage birdImage;

	// ====================== CONSTRUCTOR ======================
	
	public Bird(Pipe pipe) {
 		this.x = Bird.INITIAL_X;
		this.y = Bird.INITIAL_Y;
		this.alive = true;
		this.size = Bird.SIZE;
		this.vel = INITIAL_VELOCITY;
		this.score = 0;

		birdImage = LoadFile.loadImage("resources/sprites/bird/bird.png");
		changeColorBird();

		this.pipe = pipe;
	}

	// ======================== ACTIONS ========================

	public void jump() {
		this.vel = Bird.JUMP_FORCE;  
	}

	public void die(){
		this.alive = false;
	}

	public void revive(){
		this.alive = true;
	}

	// ====================== EXTERIOR INTERACTION ======================

	public void borderCollision(){
		if(this.y <= 0 ||
			this.y + this.size >= GameConstants.HEIGHT
		){
			die();
		}
	}

	public void pipeCollision(){
		int xp = pipe.getX(),
			yp1 = pipe.getY(), 
			yp2 = pipe.getyB(), 
			sx = pipe.getSizeX(),
			sy = pipe.getSizeY();

		boolean overlapsX = this.x < xp + sx && this.x + this.size > xp;

		boolean overlapsY1 = this.y < yp1 + sy && this.y + this.size > yp1;
		boolean overlapsY2 = this.y < yp2 + sy && this.y + this.size > yp2;

		if(overlapsX && (overlapsY1 || overlapsY2)){
			die();
		}
	}

	// ====================== UPDATE VIEW & ATTRIBUTES ======================

	private void updateScore(Pipe newPipe){
		if(newPipe != pipe){
			score++;
		}
	}

	private void updateAngle(){
		double targetAngle = Math.atan(vel * 0.10);

		targetAngle = Math.clamp(targetAngle,
                MIN_ANGLE, MAX_ANGLE); 

		angle += (targetAngle - angle) * ROTATION_SMOOTHING;

	}

	public void resetBird(){
		revive();
		this.y = Bird.INITIAL_Y;
		this.vel = INITIAL_VELOCITY;
		this.score = 0;
	}

	@Override
	public void update() {
		if(isAlive()){
			this.vel += Bird.GRAVITY_FORCE;
			
			if(vel > 30) vel = 30;
			
			this.y += vel/2;

			updateAngle();

			borderCollision();
			pipeCollision();

			if(getPipe().getX() < -Pipe.SIZE_X/2){
				this.pipe = null;
			}
		}
	}
	
	@Override 
	public void paint(Graphics2D g) {
		if(isAlive()){
			Graphics2D bird = (Graphics2D) g.create();

			int imageHeight = (int) (size * 0.8);

			double centerX = x + size / 2.0;
			double centerY = y + imageHeight / 2.0;

			bird.rotate(angle, centerX, centerY);

			bird.drawImage(birdImage, x, y, size, (int)(size*0.8), null);
			
			bird.dispose();
		}
	}

	// ====================== GETTERS & SETTERS ======================
	
	
	public boolean isAlive() {
		return alive;
	}

	public int getX() {
		return x;
	}

	public int getScore() {
		return score;
	}

	public Pipe getPipe(){
		return this.pipe;
	}

	public void setPipe(Pipe pipe){
		this.pipe = pipe;
	}

	// ====================== IMAGE ======================

	private void changeColorBird(){
		this.birdImage = SpriteColorizer.randomColorizer(birdImage, Color.WHITE);
	}

}
