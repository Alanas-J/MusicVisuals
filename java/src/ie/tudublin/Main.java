package ie.tudublin;

import c18473312.MyVisual;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch( a, new MyVisual());
		String[] b = {"Second"};
		processing.core.PApplet.runSketch( b, new MyVisual());
		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}