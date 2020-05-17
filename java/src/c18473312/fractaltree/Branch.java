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

        branch();

    }
    



    Branch(Branch branch){

        
    } //


    void show(){
        
        
        
        mv.rotate(this.angle);
        

        mv.line(0, 0, 0, amplitude);

        if(branches != null){
            mv.translate(0, amplitude);
            mv.pushMatrix();
            branches[0].show();
            mv.popMatrix();
            branches[1].show();

        } //

    } //


    void branch(){

        
        
        if (mv.branchCounter < 50){

            branches = new Branch[2];
            mv.branchCounter++;
            mv.branchCounter++;
            branches[0] = new Branch(mv, start-amplitude, amplitude/2, 30);
            branches[1] = new Branch(mv, start-amplitude, amplitude/2, -30);
        }

        


    }

}// end of branch