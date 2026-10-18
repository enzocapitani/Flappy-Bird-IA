package principal.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class SpriteColorizer {

    private static Color[] colors = {Color.DARK_GRAY, Color.BLUE, Color.YELLOW, Color.MAGENTA
    , Color.ORANGE, Color.PINK, Color.RED, Color.GREEN, Color.LIGHT_GRAY, Color.GRAY};

    public static BufferedImage colorizer(
    BufferedImage original,
    Color targetColor,
    Color replacementColor) {

        BufferedImage result = new BufferedImage(
                original.getWidth(),
                original.getHeight(),
                BufferedImage.TYPE_INT_ARGB
        );

        for (int x = 0; x < original.getWidth(); x++) {
            for (int y = 0; y < original.getHeight(); y++) {

                int pixel = original.getRGB(x, y);

                int alpha = (pixel >> 24) & 0xFF;
                int red = (pixel >> 16) & 0xFF;
                int green = (pixel >> 8) & 0xFF;
                int blue = pixel & 0xFF;

                boolean matchesColor =
                        red == targetColor.getRed()
                                && green == targetColor.getGreen()
                                && blue == targetColor.getBlue();

                if (matchesColor && alpha > 0) {
                    int newPixel =
                            (alpha << 24)
                                    | (replacementColor.getRGB() & 0x00FFFFFF);

                    result.setRGB(x, y, newPixel);
                } else {
                    result.setRGB(x, y, pixel);
                }
            }
        }

        return result;
    }

    public static BufferedImage randomColorizer(BufferedImage image, Color target){
        Random rand = new Random();
        Color selectedColor = colors[rand.nextInt(colors.length)];
        return colorizer(image, target, selectedColor);
    }
}
