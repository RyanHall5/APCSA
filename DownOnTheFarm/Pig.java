package DownOnTheFarm;
public class Pig {

    //attributes
    private String color;
    private int penSize;
    private boolean muddy;
    private double weight;

    //default constructor
    public Pig(){
        color = "Pink";
        penSize = 50;
        muddy = true;
        weight = 300.0;
    }

    //parameter constructor
    public Pig(String c, int n, boolean m, double w){
        color = c;
        penSize = n;
        muddy = m;
        weight = w;
    }

    //print pig noise
    public void makeNoise(){
        System.out.println("OINK OINK OINK");
    }

    //increases pen size (square feet)
    public void upgradePenSize(int amount){
        penSize+=amount;
    }

    public void displayPig(){
        System.out.println("Color: " + color);
        System.out.println("Pen Size: " + penSize);
        System.out.println("Muddy: " + muddy);
        System.out.println("Weight: " + weight);
    }
}