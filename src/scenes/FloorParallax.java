package scenes;

import principal.GameConstants;
import principal.utils.LoadFile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FloorParallax {

    // Both are twice of the original sprite dimensions
    public static int SIZE_X_FLOOR = 600;
    public static int SIZE_Y_FLOOR = 128;

    private Component[] floors;

    public FloorParallax(){
        floors = new Component[6];
        addImages();

    }

    private void addImages(){
        BufferedImage img1 = LoadFile.loadImage("resources/sprites/cenario/chao.png"),
                img2 = LoadFile.loadImage("resources/sprites/cenario/chaoArbusto.png"),
                img3 = LoadFile.loadImage("resources/sprites/cenario/chaoNada.png");

        BufferedImage[] sprites = {
                img1, img2, img3
        };

        for(int i = 0; i < floors.length; i++){
            floors[i] = new Component(sprites[i % sprites.length],
                    i * SIZE_X_FLOOR, GameConstants.HEIGHT - SIZE_Y_FLOOR - 24, SIZE_X_FLOOR, SIZE_Y_FLOOR);
        }

    }

    private int mostFar(){
        int dist = 0;

        for(int i = 0; i < floors.length; i++){
            if(floors[i].getX() > dist) dist = floors[i].getX();
        }

        return dist;
    }

    private void verifyPosition(){
        int mostFar = mostFar();

        for (int i = 0; i < floors.length; i++) {
            if(floors[i].getX() < -SIZE_X_FLOOR){
                floors[i].setX(mostFar + SIZE_X_FLOOR);
            }
        }
    }

    public void update(){
        verifyPosition();

        for(Component floor : floors){
            floor.update();
        }
    }

    public void drawFloor(Graphics2D g2){
        for(Component floor : floors){
            floor.paint(g2);
        }
    }

}
