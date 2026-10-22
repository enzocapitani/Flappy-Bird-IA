package scenes.parallax;

import java.awt.*;

public interface ParallaxInterface {
    void addImages();
    int mostFar();
    void verifyPosition();
    void update();
    void draw(Graphics2D g2);
}
