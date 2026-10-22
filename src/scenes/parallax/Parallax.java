package scenes.parallax;

import principal.GameConstants;
import scenes.Component;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Parallax implements ParallaxInterface {

    protected int x, y, sizeXComponemt, sizeYComponent;

    protected Component[] components;

    public Parallax(int x, int y){

    }

    public Parallax(){

    }

    @Override
    public void addImages() {}

    // TODO: This method says something and do another one, need to change !
    public void addImages(BufferedImage[] sprites, int sizex, int sizey, int velocity) {
        components = new Component[sprites.length * 2];

        for(int i = 0;i < components.length; i++){
            components[i] = new Component(sprites[i % sprites.length], i*sizex, y, sizex, sizey, velocity);
        }

    }

    @Override
    public int mostFar() {
        int dist = 0;

        for(int i = 0; i < components.length; i++){
            if(components[i].getX() > dist) dist = components[i].getX();
        }

        return dist;
    }

    @Override
    public void verifyPosition() {
        int mostFar = mostFar();

        for (int i = 0; i < components.length; i++) {
            if(components[i].getX() < -sizeXComponemt){
                components[i].setX(mostFar + sizeXComponemt);
            }
        }
    }

    @Override
    public void update() {
        verifyPosition();

        for(Component component : components){
            component.update();
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        for(Component component : components){
            component.paint(g2);
        }
    }
}
