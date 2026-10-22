package scenes.parallax;

import objects.pipe.Pipe;
import principal.GameConstants;
import principal.utils.LoadFile;
import scenes.Component;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FloorParallax extends Parallax{

    // Both are twice of the original sprite dimensions
    public static int SIZE_X_FLOOR = 600;
    public static int SIZE_Y_FLOOR = 128;

    public FloorParallax(){
        addImages();
        this.sizeXComponemt = SIZE_X_FLOOR;
        this.sizeYComponent = SIZE_Y_FLOOR;
    }

    @Override
    public void addImages(){
        BufferedImage img1 = LoadFile.loadImage("resources/sprites/cenario/chao.png"),
                img2 = LoadFile.loadImage("resources/sprites/cenario/chaoArbusto.png"),
                img3 = LoadFile.loadImage("resources/sprites/cenario/chaoNada.png");

        BufferedImage[] sprites = {
                img1, img2, img3
        };

        this.components = new Component[sprites.length * 2];

        for(int i = 0; i < components.length; i++){
            components[i] = new Component(sprites[i % sprites.length],
                    i * SIZE_X_FLOOR, GameConstants.HEIGHT - SIZE_Y_FLOOR - 24, SIZE_X_FLOOR, SIZE_Y_FLOOR, Pipe.VELOCITY);
        }

    }


}
