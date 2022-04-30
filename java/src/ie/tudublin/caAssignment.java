package ie.tudublin;

import ddf.minim.*;
import processing.core.PApplet;

public class caAssignment extends PApplet
{

    Minim minim;
    AudioPlayer heaven;
    AudioBuffer audioBuff;

    int mode = 0;

    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    float[] lerpedBuffer;

    float off = 0;
    

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		if (keyCode == ' ') {
            if (heaven.isPlaying()) {
                heaven.pause();
            } else {
                heaven.rewind();
                heaven.play();
            }
        }
	}

    public void settings() 
    {
        size(1024, 600);
    }

    public void setup()
    {

        minim = new Minim(this);
        heaven = minim.loadFile("differentheaven.mp3", 1024);
        heaven.loop();

        colorMode(RGB);

        y = height / 2;
        smoothedY = y;

        lerpedBuffer = new float[width];
    }

    public void draw()
    {
        
        // Lerped buffer
        float halfH = height / 2;
        float average = 0;
        float sum = 0;
        off += 1;
        // Calculate sum and average of the samples
        // Also lerp each element of buffer;
        for(int i = 0 ; i < audioBuff.size() ; i ++)
        {
            sum += abs(audioBuff.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], audioBuff.get(i), 0.05f);
        }
        average= sum / (float) audioBuff.size();

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);
        
        float cx = width / 2;
        float cy = height / 2;

        switch (mode) {
			case 0:
                background(0);
                for(int i = 0 ; i < audioBuff.size() ; i ++)
                {
                    //float c = map(ab.get(i), -1, 1, 0, 255);
                    float c = map(i, 0, audioBuff.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = lerpedBuffer[i] * halfH * 4.0f;
                    line(i, halfH + f, i, halfH - f);                    
                }
                break;
            case 1:
                background(0);
                for(int i = 0 ; i < audioBuff.size() ; i ++)
                {
                    //float c = map(ab.get(i), -1, 1, 0, 255);
                    float c = map(i, 0, audioBuff.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = lerpedBuffer[i] * halfH * 4.0f;
                    line(i, halfH + f, halfH - f, i);                    
                }
                break;
            case 2:
                {
                    float c = map(smoothedAmplitude, 0, 0.5f, 0, 255);
                    background(0, 0, 0, 10);
                    stroke(c, 255, 255);	
                    float radius = map(smoothedAmplitude, 0, 0.1f, 50, 300);		
                    int points = (int)map(mouseX, 0, 255, 3, 10);
                    int sides = points * 2;
                    float px = cx;
                    float py = cy - radius; 
                    for(int i = 0 ; i <= sides ; i ++)
                    {
                        float r = (i % 2 == 0) ? radius : radius / 2; 
                        // float r = radius;
                        float theta = map(i, 0, sides, 0, TWO_PI);
                        float x = cx + sin(theta) * r;
                        float y = cy - cos(theta) * r;
                        
                        //circle(x, y, 20);
                        line(px, py, x, y);
                        px = x;
                        py = y;
                    }
                }   
                break;
            case 3:
                {
                    background(0);
                    strokeWeight(2);
                    noFill();
                    float r = map(smoothedAmplitude, 0, 0.5f, 100, 2000);
                    float c = map(smoothedAmplitude, 0, 0.5f, 0, 255);
                    stroke(c, 255, 255);
                    circle(cx, cy, r);
                }
                break;
            case 4:
                {
                    background(0);
                    strokeWeight(2);
                    for(int i = 0 ; i < audioBuff.size() ; i +=10)
                    {
                        //float c = map(ab.get(i), -1, 1, 0, 255);
                        float cc = map(i, 0, audioBuff.size(), 0, 255);
                        stroke(cc, 255, 255);
                        float f = lerpedBuffer[i] * halfH * 4.0f;
                        line(i, halfH + f, i, halfH - f);
                        fill(cc);
                        circle(i, halfH + f, 5);                    
                        circle(i, halfH - f, 5);                    
                    }
                }
                break;
            case 5:
                {
                    background(0);
                    stroke(255);
                    
                    // draw the waveforms
                    for(int i = 0; i < heaven.bufferSize() - 1; i++)
                    {
                        float x1 = map( i, 0, heaven.bufferSize(), 0, width );
                        float x2 = map( i+1, 0, heaven.bufferSize(), 0, width );
                        line( x1, 50 + heaven.left.get(i)*50, x2, 50 + heaven.left.get(i+1)*50 );
                        line( x1, 150 + heaven.right.get(i)*50, x2, 150 + heaven.right.get(i+1)*50 );
                    }
                    
                    noStroke();
                    fill( 255, 128 );
                    
                    rect( 0, 0, heaven.left.level()*width, 100 );
                    rect( 0, 100, heaven.right.level()*width, 100 );
                }
                break;

        }// end switch
    }// end draw method
}// end class