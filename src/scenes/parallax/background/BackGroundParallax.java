package scenes.parallax.background;

import principal.GameConstants;
import principal.utils.LoadFile;
import scenes.parallax.Parallax;

import java.awt.image.BufferedImage;

public class BackGroundParallax extends Parallax {

    public static int SIZE_X_BACKGROUND = GameConstants.WIDTH;
    public static int SIZE_Y_BACKGROUND = GameConstants.HEIGHT;

    public BackGroundParallax(){
        BufferedImage[] sprites = {
                BackGroundAssets.image1,
                BackGroundAssets.image2,
                BackGroundAssets.image3
        };

        this.sizeXComponemt = SIZE_X_BACKGROUND;
        this.sizeYComponent = SIZE_Y_BACKGROUND;

        addImages(sprites, sizeXComponemt, sizeYComponent, 1);
    }

}
