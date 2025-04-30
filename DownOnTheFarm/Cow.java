package DownOnTheFarm;
public class Cow {

    //attributes
    private String name;
    private double weight;
    private int age;
    private boolean male;

    //default constructor
    public Cow(){
        name = "Jeremy";
        weight = 75.0;
        age = 2;
        male = true;
    }

    //parameter constructor
    public Cow(String n, double w, int a, boolean m){
        name = n;
        weight = w;
        age = a;
        male = m;
    }

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