package DownOnTheFarm;
public class Chicken {

    // attributes
    private String breed;
    private int numEggs;
    private boolean mean;
    private double weight;


    //default constructor
    public Chicken(){
        breed = "Rhode Island Red";
        numEggs = 7;
        mean = false;
        weight = 3.0;
    }

    //parameter constructor
    public Chicken(String b, int n, boolean m, double w){
        breed = b;
        numEggs = n;
        mean = m;
        weight = w;
    }

    //print chicken noise
    public void makeNoise(){
        System.out.println("CLUCK CLUCK CLUCK");
    }

    //increasing chicken's weight
    public void eatFood(int amount){
        //amount is in grams weight is in pounds
        weight += (amount/453.6);
    }

    public void displayChicken(){
        System.out.println("Breed: " + breed);
        System.out.println("Eggs: " + numEggs);
        System.out.println("Mean: " + mean);
        System.out.println("Weight (lb): " + weight);
    }

}