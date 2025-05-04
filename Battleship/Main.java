package Battleship;
/**
 * Programmer: Ryan Hall
 * Program Description: This program allows the user to play a battleship game against their friend. The game starts with player 1 placing all of their ships. Then player 2
 * attacks until all ships have been sunk and player 2's score is output to the screen along with their final attackBoard. The goal of the game is to sink all ships in as
 * few shots as possible, therefore trying to achieve the lowest score.
 * Issues: None
 */
import java.util.Scanner;

public class Main{

    //creating board
    public static Board board = new Board();

    public static void main(String[] args)  {

        Scanner reader = new Scanner(System.in);

        //variables used later
        int score = 0, sunkShips = 0;

        //welcome message
        System.out.println("Welcome to BATTLESHIP!");
        System.out.println("Player 1, please place your ships now.");
        System.out.println("Player 2, look away!");




        //array to make getting input look cleaner
        String[] ships = {"cruiser (5)", "battleship (4)", "destroyer (3)", "submarine (3)", "patrol boat (2)"};

        //adding all the ships to the board
        for(int i = 0; i < 5; i++){

            //initial print of board
            board.displayBoard();
            System.out.println();

            //getting place location
            System.out.println("Where would you like to place your " + ships[i] + "?");
            String placeLocation = reader.next().toUpperCase();

            //verifying placement input is valid
            if(!verifyInput(placeLocation)){
                System.out.println("INVALID INPUT: Enter from A1-J10");
                i -= 1;
                continue;
            }

            //splitting string into row + column
            char row = placeLocation.charAt(0);
            int column = Integer.parseInt(placeLocation.substring(1));

            //getting horizontal/vertical choice
            System.out.println("Horizontally (true) or Vertically (false)?");
            boolean directionChoice = reader.nextBoolean();

            //getting length of boat
            int length = Integer.parseInt(ships[i].substring(ships[i].length()-2, ships[i].length()-1));

            //adding ship if it fits, otherwise retry that ship
            if(!board.addShip(length, row - 64, column, directionChoice)){
                System.out.println("This Boat does not fit.");
                i -= 1;
            }
        }

        //displaying final board before attacking starts
        System.out.println("\n\n\nHere is your finished Board: ");
        board.displayBoard();







        //starting attacking game
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Player 2, it is up to you to find and sink Player 1's ships! Get ready...");
        System.out.println(board + "\n");

        //continuing attacks until game ends
        while(sunkShips != 5){

            //getting shot coordinates from user
            System.out.println("Please enter the row and column of your attack: ");
            String attack = reader.next().toUpperCase();

            //verifying shot input is valid
            if(!verifyInput(attack)){
                System.out.println("INVALID INPUT: Enter from A1-J10");
                continue;
            }

            //splitting string into row + column
            char row = attack.charAt(0);
            int column = Integer.parseInt(attack.substring(1));

            //printing the result of the user's shot
            System.out.println(secureFire(row, column));

            //storing number of sunk ships and printing out which ships are sunk
            sunkShips = board.sunkShips();

            //displaying attackBoard after shot
            System.out.println(board);

            //adding 1 to score for each shot taken by user
            score += 1;
        }

        //win message
        System.out.println("YOU DID IT!");
        System.out.println("Your score is: " + score);
        System.out.println(board);
        reader.close();
    }


    /**
     * Checks to see if input is valid A1-J10 format
     *
     * @param s     string inputted by user to be checked
     * @return      true if the input is valid, false if not
     */
    public static boolean verifyInput(String s){

        //checking length of s
        if(s.length() != 2 && s.length() != 3)
            return false;

        //splitting into X/XX format
        String letter = s.substring(0,1);
        String number = s.substring(1);

        //making sure letter is between A and J
        if(letter.charAt(0) < 65 || letter.charAt(0) > 74)
            return false;

        //making sure number is a number
        try {
            Integer.parseInt(number);
        } catch(NumberFormatException e){
            return false;
        }
        int n = Integer.parseInt(number);

        //making sure number is between 1 and 10
        return n >= 1 && n <= 10;
    }


    /**
     * Making sure the user enters a valid shot
     *
     * @param r     row of the shot
     * @param c     column of the shot
     * @return      proper display output for scenario
     */
    public static String secureFire(int r, int c){

        //turning r from ascii char val to simpler row num
        r -= 64;

        //determining output based on row and column
        if(r < 1 || r > 10 || c < 1 || c > 10)
            return "Please enter a valid spot.";
        if(board.fire(r, c))
            return "DIRECT HIT!";
        else
            return "You did not hit a ship.";
    }
}