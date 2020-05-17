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
    
        mv.translate(mv.width / 2, mv.height / 2);
        
        mv.branchCounter = 0;
        

        
        
        tree = new Branch(mv, 0f,-mv.height/7f, 0,20);


        mv.fill(255);
        mv.stroke(255);

    
        tree.show();


        for( int i = 0; i < 6; i++ ){

            mv.rotate(MyVisual.PI/6f);

            tree = new Branch(mv, 0f,-mv.height/7f, 0,20);

            mv.fill(255);
            mv.stroke(255);

    
            tree.show();


        }


    }

    


}