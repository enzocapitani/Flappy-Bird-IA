package principal.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadFile {

    public static Font loadFont(String path, float size){
        try {
            File archive = new File(path);

            return Font.createFont(Font.TRUETYPE_FONT, archive).deriveFont(size);

        } catch (FontFormatException | IOException e){
            e.printStackTrace();
        }

        return null;
    }

    public static BufferedImage loadImage(String path){
        try {

            File archive = new File(path);
            return ImageIO.read(archive);

        } catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

}
