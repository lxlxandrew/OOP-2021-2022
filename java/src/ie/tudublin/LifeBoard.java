package ie.tudublin;

import processing.core.PApplet;

public class LifeBoard {
    
    boolean[][] board;
    int size;
    float cellSize;
    PApplet pa;

    public LifeBoard(int size, PApplet pa)
    { 
        board = new boolean[size][size];
        this.size = size;
        this.pa = pa;
        cellSize = pa.width / (float) size;
        
    }

    public void randomise()
    {
        for(int row = 0; row < size; row++)
        {
            for(int col = 0; col < size; col++)
            {
                float dice = pa.random(1.0f);
                if (dice < 0.5f)
                {
                    //[row][col]
                    board[row][col] = true;
                    // or can write like this :board[row][col] = pa.random(1.0f) > 0.5f;
                }
            }
        }
    }

    public void render()
    {
        pa.background(0);

        for(int row = 0; row < size; row++)
        {
            for(int col = 0; col < size; col++)
            {
                float x = pa.map(col, 0, size, 0, pa.width);
                float y = pa.map(row, 0, size, 0, pa.width);
                x = cellSize * col;
                y = cellSize * row;

                if(board[row][col])
                {
                    pa.fill(0, 0, 255);

                }
                else{
                    pa.noFill();
                }

                pa.rect(x, y, cellSize, cellSize);
            }
        }
        


    }

}
