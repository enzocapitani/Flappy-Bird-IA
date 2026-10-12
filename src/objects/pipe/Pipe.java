package objects.pipe;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import objects.ObjectInterface;

public class Pipe implements ObjectInterface {

    private int x, y, sizeX, sizeY,
				vel;
    private int yB, gap;
    
    public Pipe(int x){
        
        this.gap = PipeConstant.GAP;
        this.sizeX = PipeConstant.SIZE_X;
        this.sizeY = PipeConstant.SIZE_Y;

        this.y = PipeConstant.RAND.nextInt(175, 600);;
		this.x = x;

        this.yB = y - gap - sizeY;

		this.vel = PipeConstant.VELOCITY;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

}
