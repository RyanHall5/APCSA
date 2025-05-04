package GameOfChance;
/**
 * Programmer:Ryan Hall
 * Program: This program allows the user to enter their guesses for 3 games of chance then displays
 * how their guesses compared to the generated random values.
 * Issues: None
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        //starting a game
        GameSimulation game = new GameSimulation();

        //getting the user's guesses
        System.out.println("What is your guess on the dice roll?");
        game.setDRGuess(reader.nextInt());
        reader.nextLine();
        System.out.println("What is your guess on the coin flip, Heads (H) or Tails (T)?");
        game.setCFGuess(reader.next());
        System.out.println("What is your guess on the spinner, red (r), green (g), blue (b), or yellow (y)?");
        game.setSpinGuess(reader.next());


        //generating random values
        game.generateRandoms();


        //displaying random values
        System.out.println("You rolled a " + game.getRandDR());
        System.out.println("You flipped " + game.getRandCF());
        System.out.println("You spun " + game.getRandSpin());

        //blank line
        System.out.println();

        //displaying appropriate result text
        game.displayResults();
        reader.close();
    }
}