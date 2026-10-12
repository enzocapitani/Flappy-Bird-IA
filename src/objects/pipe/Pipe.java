package objects.pipe;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import objects.ObjectInterface;
import principal.GameConstants;

public class Pipe implements ObjectInterface {

    public static final Random RAND = new Random();

    public static final int SIZE_X = 50;

    public static final double SIZE_Y = GameConstants.HEIGHT * 0.7;

    public static final double GAP = GameConstants.HEIGHT * 0.21;

    public static final int VELOCITY = 3;
    
    public static final double BORDER_DISTANCE = GameConstants.HEIGHT * 0.04;
    
    public static final int SPACING = (int)(GameConstants.WIDHT * 0.3);

    private int x, y, sizeX, sizeY,
				vel;
    private int yB, gap;
    
    public Pipe(int x){
        
        this.gap = (int)Pipe.GAP;
        this.sizeX = Pipe.SIZE_X;
        this.sizeY = (int)Pipe.SIZE_Y;

        this.y = Pipe.RAND.nextInt(gap+(int)Pipe.BORDER_DISTANCE, GameConstants.HEIGHT - gap - (int)Pipe.BORDER_DISTANCE);;
		this.x = x;

        this.yB = y - gap - sizeY;

		this.vel = Pipe.VELOCITY;
    }

    public void move(){
        this.x -= vel;
    }

    @Override
    public void update() {
        move();
    }

    @Override
    public void paint(Graphics2D g2) {
        g2.setColor(Color.MAGENTA);
        g2.fillRect(x, y, sizeX, sizeY);
        g2.fillRect(x, yB, sizeX, sizeY);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public int getyB() {
        return yB;
    }

    public void setyB(int yB) {
        this.yB = yB;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

}
