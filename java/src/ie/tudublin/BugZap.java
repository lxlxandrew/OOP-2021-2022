package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet{
    
    float playerX;
    float playerY;
    float playerWidth;
    float h;
    float bugX, bugY, bugWidth;
    int score;

    public void settings(){
		size(500, 500);
	}

	public void setup() {
		colorMode(RGB);
		background(0);
        smooth();

        playerX = width/2;
        playerY = height - 50;
        playerWidth = 50;
        score = 0;

        resetBug();
		
	}

	private void resetBug() {
        bugX = random(bugWidth/2, width - bugWidth/2);
        bugY = 50;
        bugWidth = 50;
    }

    void drawBug(float x, float y, float w){
        float halfW = w/2;
        stroke(255);
        noFill();
        triangle(x - halfW, y + halfW,x,y-halfW, x+halfW, y + halfW);

    }

    public void drawPlayer(float x, float y, float w){	
        stroke(255);
        noFill();
        rectMode(CENTER);
        rect(x, y, w, 20);
        line(x, y - 10, x, y - 20);
	}


    public void draw(){
        background(0);
        strokeWeight(2);
        drawPlayer(playerX, playerY, playerWidth);
        drawBug(bugX, bugY, bugWidth);

        if (frameCount % 20 == 0)
        {
            moveBug();
        }

        text("SCORE : " + score, 50, 50);
        
    }

    float playerSpeed = 5;
    public void keyPressed(){
		if (keyCode == LEFT )
		{
			if (playerX > 0)
            {
                playerX = playerX - playerSpeed;
            }
		}
		if (keyCode == RIGHT)
		{
			if (playerX < 500)
            {
                playerX = playerX + playerSpeed;
            }
		}
		if (key == ' ')
		{
			float halfW = bugWidth/2;
            if(playerX > bugX - halfW &&playerX < bugX +halfW)
            {
                score++;
                resetBug();
                line(playerX, playerY - 10, playerX, bugY);

            }
            
		}
	}

    void moveBug(){
        bugY++;
        bugX += random(-20, 20);
    }

}
