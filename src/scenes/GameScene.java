package scenes;

import principal.logic.GameLogic;
import principal.utils.LoadFile;
import scenes.parallax.BackGroundParallax;
import scenes.parallax.FloorParallax;
import scenes.parallax.Parallax;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameScene implements Scene {

    private Font scoreFont;
    private final Parallax floor, background;

    GameLogic gameLogic;

    public GameScene(){
        floor = new FloorParallax();
        background = new BackGroundParallax();
        scoreFont = LoadFile.loadFont("resources/font/YellowBanana.otf", 24f);

        gameLogic = new GameLogic();
    }

    @Override
    public void enter() {

    }

    @Override
    public void exit() {

    }

    @Override
    public void update(){
        gameLogic.update();
        updateSpritesScenes();
    }

    private void updateSpritesScenes(){
        floor.update();
        background.update();
    }

    @Override
    public void paint(Graphics2D g2) {
        paintScenario(g2);
    }

    private void paintScenario(Graphics2D g2){
        background.draw(g2);
        gameLogic.paint(g2);
        floor.draw(g2);
        gameLogic.paintBird(g2);
        drawScore(g2);
    }

    private void drawScore(Graphics2D g2){
        Graphics2D g2b = (Graphics2D) g2.create();
        g2b.setColor(Color.YELLOW);
        g2b.setFont(scoreFont);
        g2b.drawString("Score: "+gameLogic.score, 100, 100);
        g2b.dispose();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_UP){
            gameLogic.jumpBird();
        }
    }


}
