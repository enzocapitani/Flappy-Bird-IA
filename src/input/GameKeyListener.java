package input;

import scenes.SceneManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {

    SceneManager sceneManager;

    public GameKeyListener(SceneManager sceneManager){
      this.sceneManager = sceneManager;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        sceneManager.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
