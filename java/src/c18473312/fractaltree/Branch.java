package c18473312.fractaltree;
import c18473312.MyVisual;


class Branch{

    MyVisual mv;
    float start;
    float amplitude; 
    float angle = 0;

    Branch[] branches;
    
    Branch(MyVisual mv,float start, float amplitude, float angle,int branches){

        this.mv = mv;
        this.start = start;
        this.amplitude = amplitude;
        this.angle = angle;

        branch(branches);

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


    void branch(int branchAmt){

        if (branchAmt > 0){
        
            branches = new Branch[2];
            mv.branchCounter++;
            mv.branchCounter++;


            float angle = MyVisual.map(mv.lerpedAmplitude,0,1,3.14f/10f,3.14f/2f);
            
            branches[0] = new Branch(mv, start-amplitude, amplitude/1.25f, angle,branchAmt-2);
            branches[1] = new Branch(mv, start-amplitude, amplitude/1.25f, -angle,branchAmt-2);
        
        }
        

        


    }

}// end of branch