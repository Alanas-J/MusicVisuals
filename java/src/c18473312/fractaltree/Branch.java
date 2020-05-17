package c18473312.fractaltree;
import c18473312.MyVisual;


class Branch{

    MyVisual mv;
    float start;
    float amplitude; 
    float angle = 0;

    Branch[] branches;
    
    Branch(MyVisual mv,float start, float amplitude, float angle){

        this.mv = mv;
        this.start = start;
        this.amplitude = amplitude;
        this.angle = angle;

    }
    



    Branch(Branch branch){

        
    } //


    void show(){
        

        mv.fill(255);
        mv.stroke(255);
        mv.translate(start, 0);
        mv.rotate(this.angle);

        mv.line(0, 0, 0, amplitude);

        if(branches != null){

            branches[0].show();
            branches[1].show();

        } //

    } //


    void branch(){

        branches = new Branch[2];
        
        if (mv.branchCounter < 512){

            mv.branchCounter++;
            branches[0] = new Branch(mv, start+amplitude, amplitude/2, angle+30);
            branches[1] = new Branch(mv, start+amplitude, amplitude/2, angle-30);
        }

        


    }

}// end of branch