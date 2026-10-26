package scenes.scene;

import java.awt.*;
import java.awt.event.KeyEvent;

public interface Scene {
    void enter();
    void exit();
    void update();
    void paint(Graphics2D g);
    void keyPressed(KeyEvent e);

}
