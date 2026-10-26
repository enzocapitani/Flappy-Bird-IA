package scenes.scene;

import principal.GameConstants;
import principal.utils.LoadFile;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameOverScene implements Scene {

    private final Font bananaFont;

    SceneManager sceneManager;

    public GameOverScene(SceneManager sceneManager){
        this.bananaFont = LoadFile.loadFont("resources/font/YellowBanana.otf", 78f);
        this.sceneManager = sceneManager;
    }

    @Override
    public void enter() {

    }

    @Override
    public void exit() {

    }

    @Override
    public void update() {

    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(Color.RED);
        g.setFont(bananaFont);
        g.drawString("GAME OVER", GameConstants.WIDTH/2 - 256, GameConstants.HEIGHT/2);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_R) sceneManager.change(new GameScene(sceneManager));
    }
}
