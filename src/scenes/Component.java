package scenes;

import objects.ObjectInterface;
import objects.pipe.Pipe;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Component implements ObjectInterface {

    private BufferedImage image;
    private int x, y, sizex, sizey;

    public Component(BufferedImage img, int x, int y, int sizex, int sizey){
        this.image = img;
        this.x = x;
        this.y = y;
        this.sizex = sizex;
        this.sizey = sizey;
    }

    @Override
    public void update() {
        this.x -= Pipe.VELOCITY;
    }

    @Override
    public void paint(Graphics2D g2) {
        g2.drawImage(image, x, y, sizex, sizey, null);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
