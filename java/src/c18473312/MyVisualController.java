package c18473312;

import ie.tudublin.*;

public class MyVisualController extends Visual
{    
    MyVisual controlledVisual;

    
    public MyVisualController(MyVisual visual){

        controlledVisual = visual;
    }
    public MyVisualController(){

    }
   

    public int options = 4;
    int boxHeight= 100;
    int boxWidth = 200;
    

    public void settings()
    {
        size(200, 500);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
    
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            controlledVisual.visualSwitch = (controlledVisual.visualSwitch+ 1 )%4;;

        }

        
    }

    public void draw()
    {
        background(0);
        
        


        stroke(100);
        fill(25);
        rect(0, 0,200,100);

        for(int i = 0; i < options + 1  ; i++ ){

            if(i == 0){

            }

            rect(0, i*boxHeight,boxWidth,boxHeight);


        }


        textSize(20);
        fill(255);
        textAlign(CENTER,CENTER);
        text("Start Song", boxWidth/2,boxHeight/2);
        text("WindowsXP Inspired", boxWidth/2, 1*boxHeight+boxHeight/2);
        text("Fractal Tree", boxWidth/2, 2*boxHeight+boxHeight/2);
        text("AudioBands Visual", boxWidth/2, 3*boxHeight+boxHeight/2);
        text("Waveform", boxWidth/2, 4*boxHeight+boxHeight/2);


     
    }
}
