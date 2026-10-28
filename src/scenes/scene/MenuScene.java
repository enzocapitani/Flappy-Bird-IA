package scenes.scene;

import principal.GameConstants;
import principal.utils.LoadFile;
import scenes.OptionMenu;
import scenes.parallax.background.BackGroundParallax;
import scenes.parallax.floor.FloorParallax;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class MenuScene implements Scene{

    public static int LOGO_X = (int)(GameConstants.WIDTH * 0.32),
                      LOGO_Y =  (int)(GameConstants.HEIGHT * 0.20);

    public static int LOGO_X_SIZE = (int)(GameConstants.WIDTH * 0.337),
                      LOGO_Y_SIZE =  (int)(GameConstants.HEIGHT * 0.4);

    private Color color;

    SceneManager sceneManager;

    OptionMenu optionMenu;

    BufferedImage[] floor;
    BufferedImage back, logo;

    int logo_size_x, logo_size_y,
        logo_x, logo_y;
    boolean ascend;

    int tick = 0;

    private static final double MAX_LOGO_ANGLE = 5;
    private double logoAngle = 0;

    public MenuScene(SceneManager sceneManager){
        String[] opcoes = {"Play", "Options", "Exit"};

        floor = new BufferedImage[3];

        this.back = LoadFile.loadImage("resources/sprites/cenario/background1.png");
        floor[0] = LoadFile.loadImage("resources/sprites/cenario/chaoArbusto.png");
        floor[1] = LoadFile.loadImage("resources/sprites/cenario/chao.png");
        floor[2] = LoadFile.loadImage("resources/sprites/cenario/chaoNada.png");

        logo = LoadFile.loadImage("resources/sprites/flappyLogo.png");

        this.sceneManager = sceneManager;

        this.optionMenu = new OptionMenu(opcoes, GameConstants.WIDTH/2 - 45, LOGO_Y + LOGO_Y_SIZE + (int)(LOGO_Y/4));
        optionMenu.setColor(new Color(177, 216, 0));

        logo_size_x = LOGO_X_SIZE;
        logo_size_y = LOGO_Y_SIZE;
        logo_x = LOGO_X;
        logo_y = LOGO_Y;

        ascend = true;
    }


    @Override
    public void enter() {

    }

    @Override
    public void exit() {

    }

    @Override
    public void update() {
        tick++;
        if(tick % 3 == 0)
            logoEffect();
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(Color.YELLOW);

        g.drawImage(back, 0, 0, BackGroundParallax.SIZE_X_BACKGROUND, BackGroundParallax.SIZE_Y_BACKGROUND, null);

        g.drawImage(floor[0], 0,  FloorParallax.POSITION_Y,
                FloorParallax.SIZE_X_FLOOR,FloorParallax.SIZE_Y_FLOOR, null);

        g.drawImage(floor[1], FloorParallax.SIZE_X_FLOOR, FloorParallax.POSITION_Y,
                FloorParallax.SIZE_X_FLOOR,FloorParallax.SIZE_Y_FLOOR, null);

        g.drawImage(floor[2], FloorParallax.SIZE_X_FLOOR*2,  FloorParallax.POSITION_Y,
                FloorParallax.SIZE_X_FLOOR,FloorParallax.SIZE_Y_FLOOR, null);

        g.drawImage(logo, logo_x, logo_y,
                logo_size_x, logo_size_y, null);

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

    private void logoEffect() {
        if (ascend) {
            logo_size_x++;
            logo_size_y++;

            logo_x--;
            logo_y--;

            if (logo_size_x > LOGO_X_SIZE * 1.1) {
                ascend = false;
            }
        } else {
            logo_size_x--;
            logo_size_y--;

            logo_x++;
            logo_y++;

            if (logo_size_x < LOGO_X_SIZE) {
                ascend = true;
            }
        }
    }

}
