package c18473312.fractaltree;
import c18473312.*;

//import processing.core.*;

// This is an example of a visual that renders the waveform
public class FractalGenerator
{
    MyVisual mv;
    float cy = 0;
    float audioMaxHeight;
    int audioWaveWidth = 500;
    


    Stump tree;
    public FractalGenerator(MyVisual mv)
    {
        this.mv = mv;
    
        tree = new Stump(40);
        

    }

    

    public void render()
    {
        mv.background(0);
        mv.fill(255);

        // draw stump, and it's first child until null, then backtrack to go next


        mv.translate(mv.width/2,mv.height/2);
        treeRecursorDraw(tree);

    }

    void treeRecursorDraw(Stump s){

        if(s != null){
            mv.pushMatrix();

            mv.rotate(s.angle);
            mv.line(s.origin,0,s.end,0);
    
            
            treeRecursorDraw(s.child[0]);
            

            treeRecursorDraw(s.child[1]);
            mv.popMatrix();
        }
        

    }

    void drawStump(Stump s){

        mv.pushMatrix();

        mv.rotate(s.angle);
        mv.line(s.origin,0,s.end,0);

    }

}