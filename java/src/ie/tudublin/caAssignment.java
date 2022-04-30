package ie.tudublin;

import ddf.minim.*;
import processing.core.PApplet;

public class caAssignment extends PApplet
{

    Minim minim;
    AudioPlayer heaven;
    int mode = 0;

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
    }

    public void draw()
    {
        background(0);
        
        stroke( 255 );
        
        // draw the waveforms
        // the values returned by left.get() and right.get() will be between -1 and 1,
        // so we need to scale them up to see the waveform
        // note that if the file is MONO, left.get() and right.get() will return the same value
        for(int i = 0; i < heaven.bufferSize() - 1; i++)
        {
            float x1 = map( i, 0, heaven.bufferSize(), 0, width );
            float x2 = map( i+1, 0, heaven.bufferSize(), 0, width );
            line( x1, 50 + heaven.left.get(i)*50, x2, 50 + heaven.left.get(i+1)*50 );
            line( x1, 150 + heaven.right.get(i)*50, x2, 150 + heaven.right.get(i+1)*50 );
        }
        
        noStroke();
        fill( 255, 128 );
        
        // the value returned by the level method is the RMS (root-mean-square) 
        // value of the current buffer of audio.
        // see: http://en.wikipedia.org/wiki/Root_mean_square
        rect( 0, 0, heaven.left.level()*width, 100 );
        rect( 0, 100, heaven.right.level()*width, 100 );
    }
}