package ie.tudublin;

import processing.core.PApplet;

public class LifeBoard {
<<<<<<< HEAD
    
    boolean[][] board;
    boolean[][] nextBoard;
=======
    boolean[][] board;
    boolean[][] next;
>>>>>>> 9884d0309b73c9303e4ddb13071af0718ac1ecf9
    int size;
    float cellSize;
    PApplet pa;

    public LifeBoard(int size, PApplet pa)
<<<<<<< HEAD
    { 
        board = new boolean[size][size];
        nextBoard = new boolean[size][size];
        this.size = size;
        this.pa = pa;
        cellSize = pa.width / (float) size;
        
=======
    {
        board = new boolean[size][size];
        next = new boolean[size][size];
        this.size = size;
        this.pa = pa;
        cellSize = pa.width / (float) size;
>>>>>>> 9884d0309b73c9303e4ddb13071af0718ac1ecf9
    }

    public void randomise()
    {
<<<<<<< HEAD
        for(int row = 0; row < size; row++)
        {
            for(int col = 0; col < size; col++)
=======
        for(int row = 0 ; row < size ; row ++)
        {
            for(int col = 0 ; col < size ; col ++)
>>>>>>> 9884d0309b73c9303e4ddb13071af0718ac1ecf9
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

<<<<<<< HEAD
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
=======
        // Your bit goes here!

        for(int i = row - 1 ; i <= row + 1 ; i ++)
        {
            for(int j = col -1 ; j <= col + 1; j ++)
            {
                if (! (i == row && j == col))
                {
                    if (isAlive(i, j))
                    {
                        count ++;
>>>>>>> 9884d0309b73c9303e4ddb13071af0718ac1ecf9
                    }
                }
            }
        }

        return count;
    }

    public boolean isAlive(int row, int col)
    {
<<<<<<< HEAD
        if(row >= 0 && row < size && col >= 0 && col < size)
        {
            return board[row][col];
=======
        if (row >= 0 && row < size && col >= 0 && col < size)
        {
            return board[row][col]; 
>>>>>>> 9884d0309b73c9303e4ddb13071af0718ac1ecf9
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
