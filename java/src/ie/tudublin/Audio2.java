package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

/*

[fur-re-ayy] Analysis

the infinite number of waves make up the mins, and all minds are made up of these waves which then interact with one 
another, science is not supposed to give meaning the ones life or the reason behind their existence; science only explains the testa..

*/


public class Audio2 extends PApplet
{
    Minim minim;
    AudioPlayer ap; //plays audio
    AudioInput ai; //takes audio from the microphone
    AudioBuffer ab; //frame of audio into buffer (like an array)
    FFT fft;

    int mode = 0;

    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
	}

    public void settings()
    {
        size(1024, 1000);
        //fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        minim = new Minim(this);
        // Uncomment this to use the microphone
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix; 
        // ap = minim.loadFile("heroplanet.mp3", 1024);
        //ap.play();
        //ab = ap.mix;
        colorMode(RGB);

        fft = new FFT(1024, 44100);

        y = height / 2;
        smoothedY = y;

        lerpedBuffer = new float[width];
    }

    //float off = 0;

    public void draw()
    {
        //just a simple line connected with the audio
        background(0);
        stroke(255);
        float halfH = height / 2;
        for(int i = 0; i < ab.size(); i ++)
        {
            line(i, halfH, i, halfH + ab.get(i) * halfH);
        }
        //simple ex ends here
        
        fft.window(FFT.HAMMING);
        fft.forward(ab);

        stroke(0, 255, 0);
        for(int i = 0; i < fft.specSize(); i++)
        {
            line(i, 0, i, fft.getBand(i) * 10);
        }

        //fill out the mising code!!
        

        int maxIndex = 0;
        float freq = fft.indexToFreq(maxIndex);
        textSize(20);
        fill(255);
        text("Freq: " + freq, 100, 200);



        //lerping ???
        
        // Other examples we made in the class
        /*
        stroke(255);
        fill(100, 255, 255);        
        
        circle(width / 2, halfH, lerpedA * 100);

        circle(100, y, 50);
        y += random(-10, 10);
        smoothedY = lerp(smoothedY, y, 0.1f);        
        circle(200, smoothedY, 50);
        */

    }        
}
