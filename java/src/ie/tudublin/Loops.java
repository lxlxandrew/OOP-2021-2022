package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{


	int mode = 0;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		
	}

	public void keyPressed()
	{
		if (key >= '0' && key <='9')
		{
			mode = key - '0';
		}
		println(mode);
	}

	float magicMap(float a, float b, float c, float d, float e)
	{
		float output;
		a -= b;
		c -= b;
		e-= d;

		output = ((a/c)*e) + d;

		return output;
	}

	float magicMap1(float a, float b, float c, float d, float e)
	{
		float r1 = c -b;
		float r2 = e-d;
		float howFar = a - b;

		return d + ((howFar / r1) * r2);
	}

	float offset = 0;

	public void draw()
	{
		
		switch(mode)	
		{
			case 0:
				background(0);
				int bars = (int) (mouseX / 20.0f);
				float w = width / (float)bars;	
				for(int i = 0 ; i < bars ; i ++)
				{
					noStroke();
					fill(map(i, 0, bars, 0, 255), 255, 255);
					rect(map(i, 0, bars, 0, 500), 0, w, height);
				}
			break;
			case 1:
			{
				background(0);
				int squares = (int) (mouseX / 20.0f);
				float h = width / (float) squares;
				for(int i = 0; i < squares; i ++) 
				{
					noStroke();
					fill(map(i, 0, squares, 0, 255), 255, 255);
					float x = map(i, 0, squares, 0, width);
					rect(x, x, h, h);
					rect((width - h)- x , x, h, h);
				}

			break;
			} // put curly brackets around case so we an reuse variables without geting a compiling error

			case 2:
			{
				background(255);
				int circle = (int) (mouseX / 20.0f);
				float height = width / (float) circle;
				for(int j = 0; j < circle; j ++){
					for(int i = 0; i < circle; i ++) 
					{
						noStroke();
						float c = map(i + j, 0, circle * 2, 0, 255); // map the colours
						fill(c, 255, 255);
						float x = map(i, 0, circle -1, height / 2, width - (height / 2.0f));
						float y = map(j, 0, circle -1, height / 2, width - (height / 2.0f));
						circle(x, y, height);
					}
				}
			break;
			}

			case 3:
			{
				background(255);
				int circle = (int) (mouseX / 20.0f);
				offset += (mouseY / 100.0f); 
				float height = width / (float) circle;
				for(int j = 0; j < circle; j ++){
					for(int i = 0; i < circle; i ++) 
					{
						noStroke();
						float c = map(i + j + offset, 0, circle * 2, 0, 255)%256; // map the colours
						fill(c, 255, 255);
						float x = map(i, 0, circle -1, height / 2, width - (height / 2.0f));
						float y = map(j, 0, circle -1, height / 2, width - (height / 2.0f));
						circle(x, y, height);
					}
				}
			break;
			}
				
		}
	}
}
