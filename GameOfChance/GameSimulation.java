package GameOfChance;
/**
 * Programmer:Ryan Hall
 * Program: This class serves as a procedural abstraction to simulate the game of chance in the main program.
 * The class contains all the methods and attributes required to run the simulation easily from the main program.
 * I made this into a class so the program as a whole would be more dynamic and easier to change. I also just wanted to practice
 * using classes as abstractions.
 * Issues: None
 */
public class GameSimulation {

    //variables from user
    private int DRGuess;
    private String CFGuess;
    private String spinGuess;

    //random variables from computer
    private int randDR;
    private String randCF;
    private String randSpin;


    //default constructor
    public GameSimulation(){
        DRGuess = 0;
        CFGuess = null;
        spinGuess= null;
    }

    //parameter constructor
    public GameSimulation(int d, String cf, String s){
        DRGuess = d;
        CFGuess = cf;
        spinGuess= s;
    }


    //Gets and Sets for user provided variables
    public int getDRGuess(){return DRGuess;}
    public void setDRGuess(int d){DRGuess = d;}
    public String getCFGuess(){return CFGuess;}
    public void setCFGuess(String c){CFGuess = c;}
    public String getSpinGuess(){return spinGuess;}
    public void setSpinGuess(String s){spinGuess = s;}

    //gets for rand vals
    public int getRandDR(){return randDR;}
    public String getRandCF(){return randCF;}
    public String getRandSpin(){return randSpin;}


    //generating the random values needed
    //used method calls so more randoms can be added easily
    public void generateRandoms(){
        randDR = genDR();
        randCF = genCF();
        randSpin = genSpin();
    }

    //returns a random dice roll
    public int genDR(){
        return (int) (Math.random() * 6) + 1;
    }

    //returns a random coin flip
    public String genCF(){
        if ((int) (Math.random() * 2) == 0)
            return "Heads";
        return "Tails";
    }

    //returns a random spin
    public String genSpin(){
        return switch ((int) (Math.random() * 4)) {
            case 0 -> "red";
            case 1 -> "yellow";
            case 2 -> "blue";
            case 3 -> "green";
            default -> "error";
        };
    }

    //displaying what the user got correct
    public void displayResults(){
        boolean dr = DRGuess == randDR;
        boolean cf = CFGuess.substring(0,1).equals(randCF.substring(0,1));
        boolean sp = spinGuess.substring(0,1).equals(randSpin.substring(0,1));

        //probably a way to do this with a loop but I think you need either 2 lists or another class so this is fine for me
        if(dr && cf && sp)
            System.out.println("You got everything correct!");
        else if(!dr && !cf && !sp)
            System.out.println("Sorry, you somehow managed to get NOTHING correct.");
        else{
            System.out.print("You got the ");
            if(dr){
                System.out.print("dice ");
                if(cf)
                    System.out.println("and the coin ");
                else if(sp)
                    System.out.println("and the spin ");
                System.out.println("correct.");
            }
            else if(cf){
                System.out.print("coin ");
                if(sp)
                    System.out.println("and the spin ");
                System.out.println("correct.");
            }
            else
                System.out.println("spin correct.");
        }
    }


}
