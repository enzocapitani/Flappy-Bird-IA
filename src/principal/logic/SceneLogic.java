package principal.logic;

import scenes.scene.GameOverScene;
import scenes.scene.GameScene;
import scenes.scene.Scene;
import scenes.scene.SceneManager;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SceneLogic {
    SceneManager sceneManager;

    GameScene gameScene;
    GameOverScene gameOverScene;

    public SceneLogic(){
        sceneManager = new SceneManager();

        gameScene = new GameScene(sceneManager);
        gameOverScene = new GameOverScene(sceneManager);

        sceneManager.change(gameScene);
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
