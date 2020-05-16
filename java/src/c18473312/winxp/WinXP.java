package c18473312.winxp;
import c18473312.*;

import processing.core.*;

// This is an example of a visual that renders the waveform
public class WinXP
{
    MyVisual mv;
    float cy = 0;
    float audioMaxHeight;
    int audioWaveWidth = 500;
    int[] copyVertex = new int[2];

    public WinXP(MyVisual mv)
    {
        this.mv = mv;
        audioMaxHeight = mv.height/8;

        copyVertex[0]=5;
        copyVertex[1]=5;
    }

    

    public void render()
    {
        

        //vertex rotation code 
        int speedFromCentre = 5;
        copyVertex[0] = (int)(speedFromCentre*MyVisual.cos(-mv.fCounter/400%360)-speedFromCentre*MyVisual.sin(-mv.fCounter/400%360));
        copyVertex[1] = (int)(speedFromCentre*MyVisual.sin(-mv.fCounter/400%360)+speedFromCentre*MyVisual.cos(-mv.fCounter/400%360));

        if(mv.lerpedAmplitude > .4f){

            int temp1 = 2*copyVertex[0];
            int temp2 = 2*copyVertex[1];

            int shake = 1;
            if(mv.fCounter%2 == 1){
                shake = -shake;
            }

            copyVertex[0] = (temp1/4)+ (int)(shake*temp1*MyVisual.cos(-mv.fCounter%360)-temp2*MyVisual.sin(-mv.fCounter%360));
            copyVertex[1] = (temp2/4)+ (int)(shake*temp1*MyVisual.sin(-mv.fCounter%360)+temp2*MyVisual.cos(-mv.fCounter%360));
            mv.copy(10,10,mv.width-20,mv.height-20,copyVertex[0],copyVertex[1],mv.width,mv.height);

        }

        mv.resetMatrix();

        mv.colorMode(PApplet.HSB);
        mv.noStroke();
        mv.fill(0,20);
        mv.rect(0,0,mv.width,mv.height);

        mv.copy(0,0,mv.width,mv.height,copyVertex[0],copyVertex[1],mv.width,mv.height);
        //mv.copy(10,10,mv.width-20,mv.height-20,copyVertex[0],copyVertex[1],mv.width,mv.height);
        

        // random counter variable
        mv.fCounter++;
        mv.translate(mv.width/2, mv.height /2);


        if(mv.amplitude == 0){
            mv.background(15);
            mv.fill(mv.fCounter%255,100,255,255);
            mv.textAlign(MyVisual.CENTER);
            mv.textSize(40);
            mv.text("Press  ' Start Song '  to play.",0,0);
        }
        //mv.scale(MyVisual.map(mv.lerpedAmplitude,0f,1f,0.9f,1.5f));

        

         
        

        
        mv.rotate(mv.fCounter/60);
        for(int i = 0; i < 180; i++){
            mv.fill(mv.fCounter%255,100,255,255);
            mv.noStroke();
            mv.circle((int)(mv.height/2.1),0, 1);
            mv.circle((int)(-mv.height/2.1),0, 1);

            mv.rotate(-2);
        }
     

        if(mv.amplitude > .1f){
            
            int audioSamplesUsed = 15;
            for(int i = 0 ; i < audioSamplesUsed ; i ++) // use mv.ab.size() 1024 for whole buffer
            {
                mv.stroke(mv.fCounter%255,200,255,(int) MyVisual.map(mv.amplitude,0f,.4f,0f,255f));
                //mv.strokeWeight(MyVisual.map(mv.amplitude,0f,.4f,1f,8f));
                mv.strokeWeight(4);


                float x1 = MyVisual.map(i, 0, audioSamplesUsed, -audioWaveWidth / 2, audioWaveWidth / 2);
                float x2 = MyVisual.map(i+1, 0, audioSamplesUsed, -audioWaveWidth / 2, audioWaveWidth / 2);
                
                mv.line(x1,0, (x1+x2)/2,-audioMaxHeight * mv.ab.get( (int) MyVisual.map(i,0,audioSamplesUsed,1,1024)));
                mv.line((x1+x2)/2,-audioMaxHeight * mv.ab.get( (int) MyVisual.map(i,0,audioSamplesUsed,1,1024)), x2, 0);
            }

            mv.fill(mv.fCounter%255,140,255,255);
            mv.noStroke();
            mv.circle(audioWaveWidth/2,0, 1+ audioWaveWidth*mv.amplitude/2);
            mv.circle(-audioWaveWidth/2,0, 1+ audioWaveWidth*mv.amplitude/2);
        }
        else{

            mv.fill(mv.fCounter%255,100,255,255);
            mv.noStroke();
            mv.circle(audioWaveWidth/2,0, audioWaveWidth*mv.amplitude);
            mv.circle(-audioWaveWidth/2,0, audioWaveWidth*mv.amplitude);


        }       

        

    }
}