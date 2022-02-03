package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet {

    public void settings() {
		size(500, 500);
	}

	public void setup() {
		colorMode(RGB); // Red, green blue == HSB is hue, sat, brightness
		background(0);

        float playerX, playerY, playerWidth;
		
	}

	
	public void draw() {	
		

        drawPlayer(x, y, w);
		
	}

    void drawPlayer(float x, float y, float w) {
    

    
    }


	public void keyPressed() {
		if (keyCode == LEFT)
		{
			System.out.println("Left arrow pressed");
		}
		if (keyCode == RIGHT)
		{
			System.out.println("Right arrow pressed");
		}
		if (key == ' ')
		{
			System.out.println("SPACE key pressed");
		}
	}
}
