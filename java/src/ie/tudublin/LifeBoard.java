package ie.tudublin;

import processing.core.PApplet;

public class LifeBoard {
    
    boolean[][] board;
    boolean[][] nextBoard;
    int size;
    float cellSize;
    PApplet pa;

    public LifeBoard(int size, PApplet pa)
    { 
        board = new boolean[size][size];
        nextBoard = new boolean[size][size];
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
                board[row][col] = pa.random(1.0f) > 0.5f;
            }
        }
    }

    public void update()
    {
        for(int row = 0; row < size; row ++)
        {
            for(int col = 0; col < size; col ++)
            {
                int count = countCellsAround(row, col);

                    if(isAlive(row, col))
                    {
                        if(count == 2 || count == 3)
                        {
                            nextBoard[row][col] = true;
                        }
                        else 
                        {
                            nextBoard[row][col] = false;
                        }
                    }
                    else
                    {
                        if(count == 3)
                        {
                            nextBoard[row][col] = true;
                        }
                        else 
                        {
                            nextBoard[row][col] = false;
                        }
                    }
            }
        }

        //swapping the boards
        boolean[][] temp;
        temp = board;
        board = nextBoard;
        nextBoard = temp;
    }

    public int countCellsAround(int row, int col)
    {
        int count = 0;

        //i=row and j=col
        for(int i = row - 1; i <= row + 1; i++)
        {
            for(int j = col - 1; j <= col + 1; j++)
            {
                if(! (i == row && j == col)) //not counting itself 
                {
                    if(isAlive(i ,j))
                    {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public boolean isAlive(int row, int col)
    {
        if(row >= 0 && row < size && col >= 0 && col < size)
        {
            return board[row][col];
        }
        else
        {
            return false;
        }
    }

    public void render()
    {
        pa.background(0);

        for(int row = 0; row < size; row++)
        {
            for(int col = 0; col < size; col++)
            {
                float x = PApplet.map(col, 0, size, 0, pa.width);
                float y = PApplet.map(row, 0, size, 0, pa.height);
                x = cellSize * col;
                y = cellSize * row;

                if(board[row][col])
                {
                    pa.fill(0, 0, 255);

                }
                else
                {
                    pa.noFill();
                }

                pa.rect(x, y, cellSize, cellSize);
            }
        }

    }

}
