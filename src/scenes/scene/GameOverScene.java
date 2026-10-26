package scenes.scene;

import principal.GameConstants;
import principal.utils.LoadFile;
import scenes.OptionMenu;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameOverScene implements Scene {

    private final Font bananaFont;

    SceneManager sceneManager;

    OptionMenu optionMenu;

    public GameOverScene(SceneManager sceneManager){
        String[] options = {"Restart", "Menu"};

        this.bananaFont = LoadFile.loadFont("resources/font/YellowBanana.otf", 78f);
        this.sceneManager = sceneManager;

        optionMenu = new OptionMenu(options, GameConstants.WIDTH/2 - 64, GameConstants.HEIGHT/2 + 70);
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
        optionMenu.paint(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        optionMenu.keyPressed(e);

        if(e.getKeyCode() == KeyEvent.VK_ENTER) verifyOptionSelected(optionMenu.getPointerIndex());
    }

    private void verifyOptionSelected(int selected){
        switch (selected){
            case 0 -> sceneManager.change(new GameScene(sceneManager));
            case 1 -> sceneManager.change(new MenuScene(sceneManager));
        }
    }
}
