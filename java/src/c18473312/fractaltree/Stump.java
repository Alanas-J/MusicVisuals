package c18473312.fractaltree;

class Stump{

    
     //int origin[] = new int[2];
    //int end[] = new int[2];

    int angle = 5;
    int origin;
    int end;
    int iteration = 0;
    Stump[] child = new Stump[2];

    Stump(){


    }

    Stump(int height){

        this.origin = 0;
        this.end = height;

    }

    Stump(Stump parent,boolean direction){

        float childShortenRatio = .8f;

        this.origin = parent.end;
        this.end = (int)((parent.end - parent.origin)*childShortenRatio); 
        this.iteration = parent.iteration + 1;

        this.angle = parent.angle;

        if(!direction){
            this.angle = -this.angle;
        }

        if(iteration < 50){

            makeChildren();
        

        }

        
    }


    void makeChildren(){

        child[0] = new Stump(this,true);
        child[1] = new Stump(this,false);

    }



}