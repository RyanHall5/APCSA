package MiniSelections;
/**
 * Programmer:Ryan Hall
 * Program: This program outputs a grade in letter format(A-F) based on the user's inputted grade in number format(0-100)
 * Issues: None
 */
import java.util.Scanner;

public class GradeOutput {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        //getting grade num
        System.out.println("Enter your grade as an integer: ");
        int gradeNum = reader.nextInt();

        //calculating letter
        String gradeLetter;

        //calculating +/-
        if(gradeNum % 10 >= 7)
            gradeLetter = "+";
        else if(gradeNum % 10 <= 2)
            gradeLetter = "-";
        else
            gradeLetter = "";

        //calculating letter grade
        if(gradeNum>=90)
            gradeLetter = "A" + gradeLetter;
        else if(gradeNum>=80)
            gradeLetter = "B" + gradeLetter;
        else if(gradeNum>=70)
            gradeLetter = "C" + gradeLetter;
        else if(gradeNum>=60)
            gradeLetter = "D" + gradeLetter;
        else
            gradeLetter = "F";

        System.out.println(gradeLetter);
        reader.close();
    }
}