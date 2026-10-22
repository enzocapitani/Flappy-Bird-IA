package scenes;

import java.awt.*;

import javax.swing.JPanel;

import input.BirdKeyListener;
import principal.logic.GameLogic;
import principal.utils.LoadFile;
import scenes.parallax.BackGroundParallax;
import scenes.parallax.FloorParallax;
import scenes.parallax.Parallax;

public class DefaultMap extends JPanel implements Runnable {

	private Font scoreFont;

	private final int FPS = 60;
	private final Thread gameThread;

	private final Parallax floor, backgorund;
	
	GameLogic gamelogic;
	
	public DefaultMap(){
		super();

		gamelogic = new GameLogic();

		this.scoreFont = LoadFile.loadFont("resources/font/YellowBanana.otf", 24f);
		
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		this.addKeyListener(new BirdKeyListener(gamelogic));

		this.floor = new FloorParallax();
		this.backgorund = new BackGroundParallax();

		
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

				if(gamelogic.inGame()){
					gamelogic.update();
					updateSpritesScenes();
				}

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

		if(gamelogic.inGame()){

			backgorund.draw(g2);
			gamelogic.paint(g2);
			floor.draw(g2);
			drawScore(g2);

		}else{

			gamelogic.paintGameOver(g2);

		}
	}

	private void updateSpritesScenes(){
		floor.update();
		backgorund.update();
	}

	public void drawScore(Graphics2D g2){
		Graphics2D g2b = (Graphics2D) g2.create();
		g2b.setColor(Color.YELLOW);
		g2b.setFont(scoreFont);
		g2b.drawString("Score: "+gamelogic.score, 100, 100);
		g2b.dispose();
	}
	
}
