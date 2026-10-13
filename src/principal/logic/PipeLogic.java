package principal.logic;

import objects.bird.Bird;
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

    private void setNewPosition(Pipe pipe){
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

    public Pipe mostCloseToBird(Bird bird){
        Pipe bestPipe = null;
        int bestDistance = Integer.MAX_VALUE;
        
        for(int i = 0; i < pipes.size(); i++){
            int distance = distance(bird, pipes.get(i));
            
            if(distance > -Pipe.SIZE_X/2 && distance < bestDistance){
                bestDistance = distance;
                bestPipe = pipes.get(i);
            }

        }

        return bestPipe;
    }

    private int distance(Bird bird, Pipe pipe){
        return pipe.getX() - bird.getX();
    }

    public void update(){
        for (int i = 0; i < pipes.size(); i++) {
            setNewPosition(pipes.get(i)); 
            pipes.get(i).update();
        }
    }

    public void paint(Graphics2D g2){
        for (int i = 0; i < pipes.size(); i++) {
            pipes.get(i).paint(g2);
        }
    }

}
