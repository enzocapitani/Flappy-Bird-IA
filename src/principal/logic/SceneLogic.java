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
        gameScene = new GameScene();
        gameOverScene = new GameOverScene();

        sceneManager = new SceneManager();
    }

    public void update(){
        inGame();
        sceneManager.update();
    }

    public void paint(Graphics2D g){
        sceneManager.paint(g);
    }

    public void keyPressed(KeyEvent e){
        sceneManager.keyPressed(e);
    }

    private void inGame(){
        if(!gameScene.birdAlive()) sceneManager.change(gameOverScene);
    }

}
