package scenes;

import java.awt.*;

public class Pointer {

    String[] options;

    int x, y, index;

    public Pointer(int x, int y, String[] options){
        this.options = options;

        this.x = x;
        this.y = y;

        this.index = 0;

    }

    public void paint(Graphics2D g2){
        g2.setColor(Color.GREEN);
        g2.drawString("<-", x + options[index].length()*15, y);
    }

    public void moveNext(int direction){
        if(direction < 0){
            if(index == options.length - 1){
                this.y -= (options.length - 1) * 30;
                this.index = 0;
            } else {
                this.y += 30;
                this.index ++;
            }
        } else {
            if(index == 0){
                this.y -= (options.length - 1) * -30;
                this.index = options.length - 1;
            } else {
                this.y -= 30;
                this.index--;
            }
        }
    }

    public int getIndex(){
        return index;
    }

}
