package scenes.scene;

import principal.GameConstants;
import principal.utils.LoadFile;
import scenes.OptionMenu;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuScene implements Scene{

    private Font bananaFont;

    SceneManager sceneManager;

    OptionMenu optionMenu;

    public MenuScene(SceneManager sceneManager){
        String[] opcoes = {"Play", "Options", "Exit"};
        this.bananaFont = LoadFile.loadFont("resources/font/YellowBanana.otf", 78f);

        this.sceneManager = sceneManager;

        this.optionMenu = new OptionMenu(opcoes, GameConstants.WIDTH/2 - 64, GameConstants.HEIGHT/2 + 70);
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
        g.setColor(Color.YELLOW);
        g.setFont(bananaFont);
        g.drawString("FLAPPY BIRD AI", GameConstants.WIDTH/2 - 332, GameConstants.HEIGHT/2);

        optionMenu.paint(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_P) sceneManager.change(new GameScene(sceneManager));

        optionMenu.keyPressed(e);

        if(e.getKeyCode() == KeyEvent.VK_ENTER) verifyOptionSelected(optionMenu.getPointerIndex());
    }

    private void verifyOptionSelected(int selected){
        switch (selected){
            case 0 -> sceneManager.change(new GameScene(sceneManager));
            case 1 -> System.out.println("IN BUILD");
            case 2 -> System.out.println("IN BUILD");
        }
    }

}
