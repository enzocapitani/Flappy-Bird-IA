package scenes.parallax;

import principal.GameConstants;
import principal.utils.LoadFile;

import java.awt.image.BufferedImage;

public class BackGroundParallax extends Parallax{

    public static int SIZE_X_BACKGROUND = GameConstants.WIDTH;
    public static int SIZE_Y_BACKGROUND = GameConstants.HEIGHT;

    public BackGroundParallax(){
        BufferedImage[] sprites = {
                LoadFile.loadImage("resources/sprites/cenario/background3.png"),
                LoadFile.loadImage("resources/sprites/cenario/background2.png"),
                LoadFile.loadImage("resources/sprites/cenario/background1.png")
        };

        this.sizeXComponemt = SIZE_X_BACKGROUND;
        this.sizeYComponent = SIZE_Y_BACKGROUND;

        addImages(sprites, sizeXComponemt, sizeYComponent, 1);
    }

}
