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
        mv.translate(mv.height/2, mv.width/2);


        mv.colorMode(PApplet.HSB);
        for(int i = 0 ; i < audioWaveWidth ; i ++) // use mv.ab.size() 1024 for whole buffer
        {
            mv.stroke(
                PApplet.map(i, 0, audioWaveWidth, 0, 255)
                , 255
                , 255
            );

            mv.line(i-audioWaveWidth/2, -audioMaxHeight * mv.ab.get(i), audioWaveWidth-250, audioMaxHeight * mv.ab.get(i));
        }
    }
}