package principal.logic;

import scenes.scene.*;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SceneLogic {
    SceneManager sceneManager;

    GameScene gameScene;
    GameOverScene gameOverScene;
    MenuScene menuScene;

    public SceneLogic(){
        sceneManager = new SceneManager();

        gameScene = new GameScene(sceneManager);
        gameOverScene = new GameOverScene(sceneManager);
        menuScene = new MenuScene(sceneManager);

        sceneManager.change(menuScene);
    }

    public void update(){
        sceneManager.update();
    }

    public void paint(Graphics2D g){
        sceneManager.paint(g);
    }

    public void keyPressed(KeyEvent e){
        sceneManager.keyPressed(e);
    }

}
