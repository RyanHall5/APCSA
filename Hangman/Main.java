package Hangman;
/**
 * Programmer:Ryan Hall
 * Program: This program runs one game simulation of the Hangman game class: GameSimulation. It allows the user to play
 * one game of the hangman game and after the game is over, tells them whether they won or lost, and displays the correct answer regardless.
 * Issues: None
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);


        //starting the game
        GameSimulation game = new GameSimulation();

        //displaying initial hangman
        game.displayHangMan(false);

        //continue to display and ask for guess until the game is won or lost
        while(!game.getGameOver()){

            //running initial display text
            System.out.println();
            game.displayGame();

            //updating game and displaying text based on user's guess
            game.updateGame(reader.next());



        }

        //displaying the final hangman
        System.out.println();
        game.displayHangMan(false);

        //win/loss statement to the user
        if(game.getGameWon())
            System.out.println("Congratulations, you won!");
        else
            System.out.println("Sorry, you lost.");

        //revealing the final word regardless of win/loss
        System.out.println("The word was: " + game.getWord());
        reader.close();
    }
}