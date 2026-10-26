package scenes;

import principal.utils.LoadFile;

import java.awt.*;
import java.awt.event.KeyEvent;

public class OptionMenu {

    private Font bananaFont;

    private String[] options;

    private Pointer pointer;

    private int x, y;

    public OptionMenu(String[] options, int x, int y){

        bananaFont = LoadFile.loadFont("resources/font/YellowBanana.otf", 24f);
        this.options = options;

        this.x = x;
        this.y = y;

        this.pointer = new Pointer(x, y, options);

    }

    public void update(){

    }

    public void paint(Graphics2D g){
        g.setFont(bananaFont);
        g.setColor(Color.MAGENTA);
        for(int i = 0; i < options.length; i++) g.drawString(options[i], x, y + i*30);
        pointer.paint(g);
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_DOWN) changePointer(-1);
        if(e.getKeyCode() == KeyEvent.VK_UP) changePointer(1);
    }

    public void changePointer(int direction){
        pointer.moveNext(direction);
    }

    public int getPointerIndex(){
        return pointer.getIndex();
    }

}
