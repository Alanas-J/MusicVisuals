package example;


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
        copyVertex[0] = (int)(speedFromCentre*MyVisual.cos(-mv.counter/4000%360)-speedFromCentre*MyVisual.sin(-mv.counter/4000%360));
        copyVertex[1] = (int)(speedFromCentre*MyVisual.sin(-mv.counter/4000%360)+speedFromCentre*MyVisual.cos(-mv.counter/4000%360));

        if(mv.lerpedAmplitude > .2f){

            int temp1 = 2*copyVertex[0];
            int temp2 = 2*copyVertex[1];

            int shake = 1;
            if(mv.counter%2 == 1){
                shake = -shake;
            }

            copyVertex[0] = (temp1/4)+ (int)(shake*temp1*MyVisual.cos(-mv.counter%360)-temp2*MyVisual.sin(-mv.counter%360));
            copyVertex[1] = (temp2/4)+ (int)(shake*temp1*MyVisual.sin(-mv.counter%360)+temp2*MyVisual.cos(-mv.counter%360));

        }



        mv.colorMode(PApplet.HSB);
        mv.noStroke();
        mv.fill(0,10);
        mv.rect(0,0,mv.width,mv.height);

        mv.copy(0,0,mv.width,mv.height,copyVertex[0],copyVertex[1],mv.width,mv.height);

        // random counter variable
        mv.counter++;
        mv.translate(mv.width/2, mv.height /2);
        //mv.scale(MyVisual.map(mv.lerpedAmplitude,0f,1f,0.9f,1.5f));

        

         
        

        for(int i = 0; i < 180; i++){
            mv.fill(mv.counter%255,100,255,255);
            mv.noStroke();
            mv.circle(mv.width/3,0, 1);
            mv.circle(-mv.width/3,0, 1);

            mv.rotate(-2);
        }

        mv.rotate(mv.counter/60);
        
     

        if(mv.amplitude > .1f){
            
            for(int i = 0 ; i < 15 ; i ++) // use mv.ab.size() 1024 for whole buffer
            {
                mv.stroke(mv.counter%255,200,255,(int) MyVisual.map(mv.amplitude,0f,.4f,0f,255f));
                //mv.strokeWeight(MyVisual.map(mv.amplitude,0f,.4f,1f,8f));
                mv.strokeWeight(4);


                float x1 = MyVisual.map(i, 0, 15, -audioWaveWidth / 2, audioWaveWidth / 2);
                float x2 = MyVisual.map(i+1, 0, 15, -audioWaveWidth / 2, audioWaveWidth / 2);
                
                mv.line(x1,0, (x1+x2)/2,-audioMaxHeight * mv.ab.get( (int) MyVisual.map(i,0,25,1,1024)));
                mv.line((x1+x2)/2,-audioMaxHeight * mv.ab.get( (int) MyVisual.map(i,0,25,1,1024)), x2, 0);

                //mv.line(x1, y1, x2, y2);
                
                
                
    
                //mv.line(i-audioWaveWidth/2, -audioMaxHeight * mv.ab.get(i), i-audioWaveWidth/2, audioMaxHeight * mv.ab.get(i));
                
            }

            mv.fill(mv.counter%255,140,255,255);
            mv.noStroke();
            mv.circle(audioWaveWidth/2,0, 1+ audioWaveWidth*mv.amplitude/2);
            mv.circle(-audioWaveWidth/2,0, 1+ audioWaveWidth*mv.amplitude/2);
        }
        else{

            mv.fill(mv.counter%255,100,255,255);
            mv.noStroke();
            mv.circle(audioWaveWidth/2,0, audioWaveWidth*mv.amplitude);
            mv.circle(-audioWaveWidth/2,0, audioWaveWidth*mv.amplitude);


        }
 

        /*
        if(mv.amplitude > .2f){
            for(int i = 0 ; i < audioWaveWidth ; i ++) // use mv.ab.size() 1024 for whole buffer
            {
                mv.stroke(
                    PApplet.map(i, 0, audioWaveWidth, 0, 255)
                    , 255
                    , 255
                    , 100
                );
    
                mv.line(i-audioWaveWidth/2, -audioMaxHeight * mv.ab.get(i), i-audioWaveWidth/2, audioMaxHeight * mv.ab.get(i));
                
            }
        }
        */

        

        
       
    }
}