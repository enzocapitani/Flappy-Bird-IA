package principal;

import input.GameKeyListener;
import principal.logic.GameLogic;
import principal.logic.SceneLogic;
import scenes.scene.GameOverScene;
import scenes.scene.GameScene;
import scenes.scene.SceneManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {


    private Font scoreFont;

    private final int FPS = 60;
    private final Thread gameThread;

    GameLogic gamelogic;

    SceneLogic sceneLogic;

    public GamePanel(){
        super();

        gamelogic = new GameLogic();

        sceneLogic = new SceneLogic();

        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new GameKeyListener(sceneLogic));

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double frameTime = 1_000_000_000.0 / FPS;
        long lastTime = System.nanoTime();
        double delta = 0;

        while (gameThread != null) {
            long now = System.nanoTime();
            delta += (now - lastTime) / frameTime;
            lastTime = now;

            if (delta >= 1) {

                sceneLogic.update();

                repaint();
                delta--;

            } else {
                Thread.yield();
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        sceneLogic.paint(g2);

    }
}
