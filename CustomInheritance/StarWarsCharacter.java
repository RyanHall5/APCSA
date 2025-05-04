package CustomInheritance;
/**
 * Programmer: Ryan Hall
 * Program Description: This program contains the StarWarsCharacter file and its subclasses that are inherited from it.
 * Issues: None
 */
public class StarWarsCharacter {

    private String name;
    private double bal;

    public StarWarsCharacter(){
        name = "";
        bal = 0.0;
    }
    public StarWarsCharacter(String n, double b){
        name = n;
        bal = b;
    }

    //getters and setters
    public String getName(){return name;}
    public void setName(String n){name = n;}
    public double getBal(){return bal;}
    public void setBal(double b){bal = b;}


    //donating money to either the rebellion or Sith (unspecified)
    public boolean donate(double b){
        if(b < 0)
            return false;
        if(bal > b)
            bal -= b;
        return bal + b > b;
    }

    //gaining money by working
    public void work(double b){
        bal += b;
    }

    //displaying object as a string
    public String toString(){
        return name + " has $" + bal;
    }

    //comparing object to one of the same type
    public boolean equals(StarWarsCharacter other){
        if(other == null)
            return false;
        return name.equals(other.getName()) &&  (int) bal == (int) other.getBal();
    }
}

class Rebel extends StarWarsCharacter {

    boolean forceConnection;

    public Rebel(){
        super();
        forceConnection = false;
    }
    public Rebel(String n, double b, boolean f){
        super(n, b);
        forceConnection = f;
    }

    //getters and setters
    public boolean getForceConnection(){return forceConnection;}
    public void setForceConnection(boolean f){forceConnection = f;}



    //declaring ones support for the rebellion
    public void supportRebellion(){
        System.out.println("My name is " + super.getName() + " and I support the rebellion!");
    }

    //seeing whether one has a connection to the force yet
    public void feelTheForce(){
        if(forceConnection)
            System.out.println("hmmm...    The Force is strong with this one.");
        else
            System.out.println("hmmm...    The Force has not found this one yet.");
    }


    //displaying the object as a string
    public String toString(){
        return super.toString() + " and supports the rebellion";
    }

    //comparing object to one of the same type
    public boolean equals(Rebel other){
        if(!super.equals(other))
            return false;
        return forceConnection == other.getForceConnection();
    }
}


class Jedi extends Rebel{

    String lightSaberColor;

    public Jedi(){
        super();
        lightSaberColor = "Blue";
    }
    public Jedi(String n, double b, boolean f, String c){
        super(n,b,f);
        lightSaberColor = c;
    }

    //getters and setters
    public String getLightSaberColor(){return lightSaberColor;}
    public void setLightSaberColor(String s){lightSaberColor = s;}

    //Audio from a jedi performing an attack
    public void attack(){
        System.out.println("Pssshhew Swoosh Kksssshhhh Swoosh Kksssshhhh ");
    }

    //Audio from a jedi finding their inner peace and concentration
    public void meditate(){
        System.out.println("Aommmm... Aommmm...");
    }


    //displaying object as a string
    public String toString(){
        return super.toString() + ", wielding a " + lightSaberColor + " light saber";
    }

    //comparing object to one of the same type
    public boolean equals(Jedi other){
        if(!super.equals(other))
            return false;
        return lightSaberColor.equals(other.getLightSaberColor());
    }
}