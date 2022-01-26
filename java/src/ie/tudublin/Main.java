package ie.tudublin;

public class Main
{
    public static void main(String[] args)
    {
        //instance of the cat class
        Cat ginger = new Cat("Ginger"); 

        //killing the cat until he is dead dead lol
        while(ginger.getNumLives() > 0) {    
            ginger.kill();
        }        

    }
}