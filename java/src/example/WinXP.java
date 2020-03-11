package example;

import processing.core.*;

// This is an example of a visual that renders the waveform
public class WinXP
{
    MyVisual mv;
    float cy = 0;
    float audioMaxHeight;
    int audioWaveWidth = 500;
   

    public WinXP(MyVisual mv)
    {
        this.mv = mv;
        audioMaxHeight = mv.height/5;

    }


    public void render()
    {
        mv.colorMode(PApplet.HSB);
        mv.noStroke();
        mv.fill(0,20);
        mv.rect(0,0,mv.width,mv.height);
        mv.copy(0,0,mv.width,mv.height,10,10,mv.width,mv.height);

        // random counter variable
        mv.counter++;
        mv.translate(mv.height/2, mv.width/2);
        mv.fill(mv.counter%255,100,255,100);

        if(mv.amplitude > .2f){
           // mv.circle(0, 0, audioWaveWidth);
        }
     

        mv.rotate(mv.counter/60);
        //mv.circle(0,audioWaveWidth/2, audioWaveWidth*mv.amplitude);
        //mv.circle(0,-audioWaveWidth/2, audioWaveWidth*mv.amplitude);


        for(int i = 0 ; i < audioWaveWidth ; i ++) // use mv.ab.size() 1024 for whole buffer
        {
            mv.stroke(
                PApplet.map(i, 0, audioWaveWidth, 0, 255)
                , 255
                , 255
            );

            mv.line(i-audioWaveWidth/2, -audioMaxHeight * mv.ab.get(i), i-audioWaveWidth/2, audioMaxHeight * mv.ab.get(i));
            
        }
    }
}