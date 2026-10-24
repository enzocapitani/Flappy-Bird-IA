package principal;

import input.GameKeyListener;
import principal.logic.GameLogic;
import scenes.GameScene;
import scenes.SceneManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {


    private Font scoreFont;

    private final int FPS = 60;
    private final Thread gameThread;

    GameLogic gamelogic;

    SceneManager sceneManager;

    public GamePanel(){
        super();

        gamelogic = new GameLogic();

        sceneManager = new SceneManager(new GameScene());

        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new GameKeyListener(sceneManager));

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

                sceneManager.update();

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
        sceneManager.paint(g2);

    }


}
