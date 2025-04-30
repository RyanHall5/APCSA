package MiniSelections;
/**
 * Programmer:Ryan Hall
 * Program: This program simulates the rock paper scissors game between the user and the computer
 * Issues: None
 */
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);


        //getting player and computer moves
        System.out.println("Input Rock (0), Paper (1), or Scissors (2): ");
        int playerMove = reader.nextInt();
        int compMove = (int) (Math.random() * 3);


        //calculating winner
        String winner = "";
        if(playerMove == compMove)
            winner = "Draw";
        else if((playerMove == 0 && compMove == 2) || (playerMove == 1 && compMove == 0) || (playerMove == 2 && compMove == 1))
            winner = "Player";
        else
            winner = "Computer";




        //array for easy printing
        String[] rpsVals = {"Rock", "Paper", "Scissors"};
        
        //displaying winner
        if(winner.equals("Player"))
            System.out.println(rpsVals[playerMove] + " beats " + rpsVals[compMove] + ", You win!");
        else if(winner.equals("Computer"))
            System.out.println(rpsVals[compMove] + " beats " + rpsVals[playerMove] + ", I win!");
        else
            System.out.println("It is a draw!");
        reader.close();
    }
}