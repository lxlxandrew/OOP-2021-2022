package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(RGB); // Red, green blue == HSB is hue, sat, brightness
		background(0);
		
	}

	
	public void draw()
	{	
		/* 
		stroke(0); //outline
		fill(0, 0, 255);
		noFill();
		noStroke();

		background(255, 255, 0); // Greyscale (0 is black, 255 is white)
		line(10, 10, 200, 200); // x1, y1, x2, y2
		circle(200, 250, 50); //cx, cy, r
		ellipse(50, 200, 90, 200); //cx, cy, w, h

		rectMode(CENTER);
		rect(100, 20, 100, 20); //tlx(top left), tly(top left), w, h

		rectMode(CORNER);
		rect(300, 20, 100, 20); //tlx(top left), tly(top left), w, h

		point(20, 300); // a single dot

		triangle(10, 400, 50, 450, 300, 200); // x1, y1, x2, y2, x3, y3 (pairs) 
		*/

		//illuminati symbol exerice
		background(255,0,0);
		noStroke();

		fill(255,255,0);
		circle(250,250,450);

		fill(0,255,255);
		triangle(10,450,490,450,250,5);

		fill(200, 0, 0);
		ellipse(250,250,250,100);

		fill(0);
		circle(250,250,75);
		
		
	}
}
