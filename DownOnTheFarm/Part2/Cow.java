package DownOnTheFarm.Part2;
/**
 * Programmer:Ryan Hall
 * Program: This program stores all the data and methods necessary for a "Cow" in order to be used correctly in the main method.
 * Issues: None
 */
public class Cow {

    //attributes
    private String name;
    private double weight;
    private int age;
    private boolean male;
    private String breed;


    //default constructor
    public Cow(){
        name = "Jeremy";
        weight = 75.0;
        age = 2;
        male = true;
        breed = "angus";
    }

    //parameter constructor
    public Cow(String n, double w, int a, boolean m, String b){
        name = n;
        weight = w;
        age = a;
        male = m;
        breed = b;
    }


    //accessors
    public String getName(){return name;}
    public double getWeight(){return weight;}
    public int getAge(){return age;}
    public boolean getMale(){return male;}
    public String getBreed(){return breed;}

    //mutators
    public void setName(String n){name=n;}
    public void setWeight(double w){weight=w;}
    public void setAge(int n){age=n;}
    public void setMale(boolean b){male=b;}
    public void setBreed(String s){breed=s;}


    //print cow noise
    public void makeNoise(){
        System.out.println("moo moo moo");
    }

    //increasing age by one
    public void haveBirthday(){
        age++;
    }

    //displays cow's attributes
    public void displayCow(){
        System.out.println("Name: " + name);
        System.out.println("Weight: " + weight);
        System.out.println("Age: " + age);
        if (male)
            System.out.println("Gender: Male" );
        else
            System.out.println("Gender: Female");
    }


}