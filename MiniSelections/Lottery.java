package MiniSelections;
/**
 * Programmer:Ryan Hall
 * Program: This program allows the user to guess a 2 digit number and awards them various prize amounts dependent
 * on a randomly generated 2 digit number
 * Issues: None
 */
import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        //getting 2-digit number from user
        System.out.println("Enter a two digit number: ");
        int num = reader.nextInt();

        //creating random 2 digit num
        int randNum = (int) (Math.random() * 90) + 10;

        //displaying lotto num
        System.out.println("The lotto number is: " + randNum);

        //checking if they won anything
        if(randNum == num) {
            System.out.println("YOU GOT IT!!!");
            System.out.println("You win the Jackpot of $10,000");
        } else if((randNum%10 == num/10) && (randNum/10 == num%10)){
            System.out.println("You got both digits correct.");
            System.out.println("You win $2,000");
        } else if(((num%10 == randNum%10) || (num%10 == randNum/10)) || ((num/10 == randNum%10) || (num/10 == randNum/10)) ){
            System.out.println("You got one digit correct.");
            System.out.println("You win $500");
        } else{
            System.out.println("You did not win anything :(");
        }

        reader.close();
    }
}