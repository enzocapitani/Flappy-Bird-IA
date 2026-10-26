package input;

import principal.logic.SceneLogic;
import scenes.scene.SceneManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {

    SceneLogic sceneLogic;

    public GameKeyListener(SceneLogic sceneLogic) {
        this.sceneLogic = sceneLogic;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        sceneLogic.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
