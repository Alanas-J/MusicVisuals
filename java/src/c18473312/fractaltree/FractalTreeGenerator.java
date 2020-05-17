package c18473312.fractaltree;
import java.util.Map;

import c18473312.*;

//import processing.core.*;

// This is an example of a visual that renders the waveform
public class FractalTreeGenerator
{
    MyVisual mv;
    float cy = 0;
    float audioMaxHeight;
    int audioWaveWidth = 500;


    

    
    Branch root;

    Branch tree;
    public FractalTreeGenerator(MyVisual mv) {
        this.mv = mv;
        
    }

    public void render() {
        mv.colorMode(MyVisual.HSB);
        mv.strokeWeight(1);

        mv.fill(0,40);
        mv.rect(-1, -1, mv.width+1, mv.height+1);


        mv.fill(255);
        mv.stroke(255);


        mv.fCounter++;

        for( int i = 0; i < 6; i++ ){
            mv.resetMatrix();
            

            mv.translate(mv.width / 2, mv.height / 2);
            mv.branchCounter = 0;
        
            mv.rotate( MyVisual.map(mv.fCounter%360, 0, 360, 0, MyVisual.PI*2));
            mv.rotate( MyVisual.map((float)i, 0f, 6f, 0f, MyVisual.PI*2));

            tree = new Branch(mv, 0f, MyVisual.map(mv.lerpedAmplitude,0,.5f,-mv.height/15f,-mv.height/4f), 0,20);

            mv.fill((mv.fCounter/10)%255);
            mv.stroke((mv.fCounter/10)%255,255,255);

    
            tree.show();


        }


    }

    


}