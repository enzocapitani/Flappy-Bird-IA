package scenes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import input.BirdKeyListener;
import objects.bird.Bird;
import principal.logic.GameLogic;

public class DefaultMap extends JPanel implements Runnable {

	private final int FPS = 60;
	private final Thread gameThread;
	
	GameLogic gamelogic;
	
	public DefaultMap(){
		super();
		
		gamelogic = new GameLogic();
		
		this.setBackground(Color.BLACK);
		this.setPreferredSize(new Dimension(900, 600));
		this.setFocusable(true);
		this.addKeyListener(new BirdKeyListener(gamelogic.getBird()));
		
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
	            	
	            	gamelogic.update();
	            	
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
		
		gamelogic.paint(g2);
	}
	
}
