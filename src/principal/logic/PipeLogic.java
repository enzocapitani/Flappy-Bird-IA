package principal.logic;

import objects.pipe.*;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class PipeLogic {
    
    ArrayList<Pipe> pipes;

    private int spacing;

    public PipeLogic(){
        this.pipes = new ArrayList<>();
        this.spacing = Pipe.SPACING;
        generatePipes();
    }

    private void generatePipes(){
        for (int i = 0; i < 10; i++) {
            this.pipes.add(new Pipe(900 + i * spacing));
        }
    }

    private void verifyPosition(Pipe pipe){
        if (pipe.getX() < -Pipe.SIZE_X) {
            pipe.setX(mostFar() + spacing);
        }
    }

    private int mostFar(){
        int dist = 0;
        
        for(int i = 0; i < pipes.size(); i++){
            if(pipes.get(i).getX() > dist) dist = pipes.get(i).getX();
        }

        return dist;
    }

    public void update(){
        for (int i = 0; i < pipes.size(); i++) {
            verifyPosition(pipes.get(i)); 
            pipes.get(i).update();
        }
    }

    public void paint(Graphics2D g2){
        for (int i = 0; i < pipes.size(); i++) {
            pipes.get(i).paint(g2);
        }
    }

}
