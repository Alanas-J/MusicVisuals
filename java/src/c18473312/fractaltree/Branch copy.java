package c18473312.fractaltree;
import c18473312.MyVisual;


class Branch{

    MyVisual mv;
    float startX;
    float startY;
    float endX;
    float endY;
    float angle = 0;

    Branch[] branches;
    

    Branch(MyVisual mv,float startX, float startY, float endX, float endY){

        this.mv = mv;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;

    }


    

    Branch(Branch branch){

        this.startX = branch.endX;
        this.startY = branch.endY;
    }


    void show(){
        
        

        mv.fill(255);
        mv.stroke(255);

        mv.rotate(this.angle);

        mv.line(this.startX, this.startY, this.endX,this.endY);

        if(branches != null){

            branches[0].show();
            branches[1].show();

        }

    }


    void branch(){

        branches = new Branch[2];
        
        //branches[0] = new Branch()


    }

}// end of branch