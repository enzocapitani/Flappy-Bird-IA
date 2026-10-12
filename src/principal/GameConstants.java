package principal;

import java.awt.Dimension;
import java.awt.Toolkit;

public class GameConstants {

    private static Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); 

    public static final int WIDHT = dimension.width;
    public static final int HEIGHT = dimension.height;
    public static final int AREA = WIDHT*HEIGHT;

}
