package principal.utils;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LoadFile {

    public static Font loadFont(String path){
        try {
            File archive = new File(path);

            return Font.createFont(Font.TRUETYPE_FONT, archive).deriveFont(24f);

        } catch (FontFormatException | IOException e){
            e.printStackTrace();
        }

        return null;
    }

}
