package ie.tudublin;

import c18473312.MyVisual;
import c18473312.MyVisualController;

public class Main
{	

	public void startUI()
	{

		MyVisual visualizer = new MyVisual(); 

		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch( a, visualizer );
		String[] b = {"Second"};
		processing.core.PApplet.runSketch( b, new MyVisualController(visualizer));
		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}