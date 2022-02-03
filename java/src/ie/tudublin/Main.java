package ie.tudublin;

public class Main
{

    private static void BugZap() {

        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new BugZap());

    }

    public static void helloProcessing() {

		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new HelloProcessing());
    }

    public void cat()
    {
        /* System.out.println("Hello world");

        Animal misty = new Animal("Misty");
        Animal lucy = new Animal("Lucy");

        lucy = misty;
        misty.setName("Tara");

        System.out.println(misty);
        Syst em.out.println(lucy);*/

        
        Cat cat = new Cat("Ginger");

        while(cat.getNumLives() > 0)
        {
            cat.kill();
        }
        cat.kill();

    }
    public static void main(String[] args) {

        BugZap();
        //helloProcessing();   

    }

}