package principal;

import java.awt.GraphicsEnvironment;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.Insets;
import java.awt.Toolkit;

public class GameConstants {

    private static final GraphicsConfiguration CONFIG =
            GraphicsEnvironment
                    .getLocalGraphicsEnvironment()
                    .getDefaultScreenDevice()
                    .getDefaultConfiguration();

    private static final Rectangle BOUNDS =
            CONFIG.getBounds();

    private static final Insets INSETS =
            Toolkit.getDefaultToolkit()
                    .getScreenInsets(CONFIG);

    public static final int WIDTH =
            BOUNDS.width - INSETS.left - INSETS.right;

    public static final int HEIGHT =
            BOUNDS.height - INSETS.top - INSETS.bottom;

    public static final int AREA = WIDTH * HEIGHT;
}