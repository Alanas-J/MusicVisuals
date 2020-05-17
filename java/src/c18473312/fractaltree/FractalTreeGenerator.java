package c18473312.fractaltree;
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


        
        root = new Branch(mv, 0f,mv.height/5f , 0f);

        
        root.show();


    }

    


}