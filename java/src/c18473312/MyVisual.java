package c18473312;

import c18473312.fractaltree.FractalGenerator;
import c18473312.winxp.WinXP;
import ie.tudublin.*;

public class MyVisual extends Visual
{    
    WaveForm wf;
    AudioBandsVisual abv;
    WinXP wxp;
    FractalGenerator tree;
    int visualSwitch = 0;
    int playSong = 0;

    public float fCounter = 0;

    public void settings()
    {
        size(1400, 800);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("INZO - Overthinker.mp3");        
        
        // Call this instead to read audio from the microphone
        //startListening(); 
        
        wf = new WaveForm(this);
        abv = new AudioBandsVisual(this);
        wxp = new  WinXP(this);
        tree = new FractalGenerator(this);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            as.stop();
            as.trigger();
        }
    }

    public void draw()
    {
        if(playSong == 1){
            as.stop();
            as.trigger();
            playSong = 0;
        }


        
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 
        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();   
        
        // __________________________ RENDERER CODE


        switch(visualSwitch){

            case 0 : 
                wxp.render();
                break;
            case 1 : 
                
                break;

            case 2 : 
                background(0);
                abv.render();
                break;

            case 3 : 
                background(0);
                wf.render();
                break;
            
            default:
                break;

        }
        //wf.render();
        //abv.render();
        //
        //tree.render();
    }
}
