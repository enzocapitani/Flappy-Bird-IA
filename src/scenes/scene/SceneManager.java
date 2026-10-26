package scenes.scene;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SceneManager {

    private Scene current;
    private Scene pending;

    public SceneManager(){

    }

    public void change(Scene next){
        this.pending = next;
    }

    public void update(){
        Scene next = pending;

        // If is not null, there is a change!
        if(next != null){
            current = next;
            pending = null;
        }

        current.update();
    }

    public void paint(Graphics2D g2){
        current.paint(g2);
    }

    public void keyPressed(KeyEvent e){
        current.keyPressed(e);
    }

}
