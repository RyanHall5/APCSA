package StringAnalyzer;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String str = reader.nextLine();


        //printing original string
        //can be used to display the variable to user
        System.out.println("1. String: " + str);

        //printing string length
        //used to get length of string maybe to iterate throughout it
        System.out.println("2. Length of String: " + str.length());

        //printing letter at an index
        //can be used to access a character at a certain index
        System.out.println("Enter a number from 0-" + (str.length() - 1));
        int i = reader.nextInt();
        System.out.println("3. Character at " + i + ": " + str.charAt(i));

        //printing substring
        //can be used to access only part of a string
        System.out.println("Enter a number from 0-" + (str.length() - 1));
        i = reader.nextInt();
        System.out.println("Enter a new number from " + i + "-" + (str.length() - 1));
        int j = reader.nextInt();
        System.out.println("4. Substring from " + i + "-" + (str.length() - 1) + ": " + str.substring(i, j));

        //clearing input line
        reader.nextLine();

        //printing upper/lowercase
        //can be used to simplify comparing strings
        System.out.println("Would you like to see the string in \"uppercase\" or \"lowercase\"");
        String s = reader.nextLine();
        if (s.equals("uppercase"))
            System.out.println("5. String as uppercase: " + str.toUpperCase());
        else
            System.out.println("5. String as lowercase: " + str.toLowerCase());

        //printing index of character or substring
        //can be used to find location of something within a string
        System.out.println("Enter a character or substring: ");
        String sub = reader.nextLine();
        if (str.toLowerCase().indexOf(sub.toLowerCase()) == -1)
            System.out.println("6. index of " + sub + ": Not Found");
        else
            System.out.println("6. index of " + sub + ": " + str.toLowerCase().indexOf(sub.toLowerCase()));

        //printing string concatenated with a new string
        //can be used to add to an existing string
        System.out.println("Enter another string to be added to the original string");
        String str2 = reader.nextLine();
        reader.close();
        System.out.println("7. original string + new string: " + str + str2);

        
        //printing number vowels and consonants in string
        //can be used to count occurances of something within a string
        String vowels = "aeiou";
        String cons = "bcdfghjklmnpqrstvwxyz";
        int consCount = 0, vowCount = 0;
        
        for (i = 0; i < str.length(); i++) {
             if (cons.indexOf(str.toLowerCase().charAt(i)) != -1)
                consCount+=1;
             else if (vowels.indexOf(str.toLowerCase().charAt(i)) != -1)
                vowCount+=1;
             else
                 System.out.println("Didn't record: " + str.charAt(i));

        }
        System.out.println("8. Number of vowels in \"" + str + "\": " + vowCount);
        System.out.println("8. Number of consonants in \"" + str + "\": " + consCount);
        
    }
}