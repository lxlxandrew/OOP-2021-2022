package ie.tudublin;

public class Cat extends Animal
{
    //declaring variables
    private int numLives;

    //constructor
    public Cat(String name)
    {
        super(name);
        numLives = 9;
    }

    //get and set methods
    public int getNumLives() {
        return numLives;
    }

    public void setNumLives(int numLives) {
        this.numLives = numLives;
    }


    //method to kill the cat
    public void kill(){
        if(numLives > 0){
            numLives = numLives - 1;
            System.out.println("Ouch!");
        }
        if(numLives == 0){
            System.out.println("Dead!");
        }
    }


}