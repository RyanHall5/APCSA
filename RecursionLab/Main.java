package RecursionLab;
/**
 * Programmer: Ryan Hall
 * Program Description: This program takes in a number from the user and prints the factorial of that number.
 * It also takes in a String, cleans the string of punctuation, spaces, and cases, then determines of the string is a palindrome
 * Issues: None
 */
import java.util.Scanner;
public class Main{
    public static void main(String[] args)  {

        Scanner reader = new Scanner(System.in);

        //factorial
        System.out.println("Enter a number: ");
        int num = reader.nextInt();
        System.out.println(num + "! = " + factorial(num));


        //clearing line
        reader.nextLine();

        //palindrome
        System.out.println("Enter a word/phrase: ");
        String phrase = reader.nextLine();

        //cleaning input of spaces/punctuation/cases
        String removables = " ,.-()!?";
        String strippedPhrase = phrase.toLowerCase();
        for(int i = 0; i < removables.length(); i++) {
            while(strippedPhrase.contains(removables.substring(i, i + 1)))
                strippedPhrase = strippedPhrase.replace(removables.substring(i, i + 1), "");
        }

        //displaying output of palindrome result
        if(palindrome(strippedPhrase))
            System.out.println(phrase + " is a palindrome!");
        else
            System.out.println(phrase + " is NOT a palindrome, sorry!.");
        reader.close();
    }

    //returns whether or not a string is a palindrome using a recursive approach
    public static boolean palindrome(String s){
        if(s.length() <= 1)
            return true;
        else if(s.substring(0,1).equals(s.substring(s.length() - 1)))
            return palindrome(s.substring(1, s.length() - 1));
        return false;
    }
    

    //returns the factorial of a number using a recursive approach
    public static int factorial(int n){
        if(n == 0)
            return 1;
        else
            return factorial(n - 1) * n;
    }
}