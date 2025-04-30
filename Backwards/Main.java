/**
 * Programmer:Ryan Hall
 * Program:This program takes a 3-digit number from the user and returns the number reversed using 2
 * different methods of reversing the number.
 * Issues: None
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        //getting user input
        System.out.println("Please enter a three digit number: ");
        int num = reader.nextInt();

        //converting to a string
        String numAsString = Integer.toString(num);

        //indexing through the number from back to front printing out each num
        System.out.print("Reversed using String methods: ");
        for(int  i = numAsString.length()-1; i >= 0; i--){
            System.out.print(numAsString.charAt(i));
        }


        //clearing line
        System.out.println("");



        //going by each place in the number starting with ones place ending with hundreds place
        int divisor = 10;
        System.out.print("Reversed using mod operator: ");
        for(int i  = 0; i < 3; i++, divisor*=10){
            int remainder = num%divisor;
            System.out.print(remainder/(divisor/10));
            num -= remainder;
        }
        reader.close();
    }
}