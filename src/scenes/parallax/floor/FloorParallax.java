package scenes.parallax.floor;

import objects.pipe.Pipe;
import principal.GameConstants;
import principal.utils.LoadFile;
import scenes.parallax.Component;
import scenes.parallax.Parallax;

import java.awt.image.BufferedImage;

public class FloorParallax extends Parallax {

    // Both are twice of the original sprite dimensions
    public static int SIZE_X_FLOOR = 600;
    public static int SIZE_Y_FLOOR = 128;

    public static int POSITION_Y = GameConstants.HEIGHT - SIZE_Y_FLOOR - 24;

    public FloorParallax(){
        addImages();
        this.sizeXComponemt = SIZE_X_FLOOR;
        this.sizeYComponent = SIZE_Y_FLOOR;
    }

    @Override
    public void addImages(){
        BufferedImage[] sprites = {
                FloorAssets.img1, FloorAssets.img2, FloorAssets.img3
        };

        this.components = new Component[sprites.length * 2];

        for(int i = 0; i < components.length; i++){
            components[i] = new Component(sprites[i % sprites.length],
                    i * SIZE_X_FLOOR, POSITION_Y, SIZE_X_FLOOR, SIZE_Y_FLOOR, Pipe.VELOCITY);
        }

    }


}
