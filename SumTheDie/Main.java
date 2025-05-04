package SumTheDie;
/**
 * Programmer:Ryan Hall
 * Program: This program displays the data for simulating 36, 500, and 10000 dice rolls and compares the experimental data to the expected data.
 * Issues: None
 */
import java.text.DecimalFormat;
public class Main{

    //Global variables so they don't have to be declared twice
    public static double[] theoProbs = {1.0/36,2.0/36,3.0/36,4.0/36,5.0/36,6.0/36,5.0/36,4.0/36,3.0/36,2.0/36,1.0/36};
    public static DecimalFormat df = new DecimalFormat("#.####");

    public static void main(String[] args) {


        //introduction text
        System.out.println("2 Die Simulation ");
        System.out.println("Theoretical Probability of rolling two die: ");
        System.out.println("X     \t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10\t\t11\t\t12");
        System.out.print("P(X)    ");
        for(double prob: theoProbs)
            System.out.print(df.format(prob) + "  ");

        //printing data for 36, 500, and 10,000 dice rolls
        printTable(36);
        printTable(500);
        printTable(10000);
    }

    //simulates count trials and prints the resulting data in the form of a table
    public static void printTable(int count){
        int sum;
        int[] counts = new int[11];
        String spaces = "        "; //will be used later for formatting the table

        //clearing lines for formatting
        System.out.println("\n");

        //simulating count rolls
        for(int i = 0; i < count; i++){
            sum = ((int) (Math.random() * 6) + 1) + ((int) (Math.random() * 6) + 1);
            counts[sum-2]++;
        }

        //all the data for count rolls
        System.out.println("Results Rolling " + count + " die: ");
        System.out.println("X\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10\t\t11\t\t12");
        System.out.print("Count\t");

        //Printing out counts of each value
        for(int n: counts)
            System.out.print(n + spaces.substring(Integer.toString(n).length()));

        //Printing out Em Prob of each value
        System.out.print("\nEm Prob\t");
        for(int n: counts)
            System.out.print(df.format((double) n / count) + spaces.substring(df.format((double) n / count).length()));

        //Printing out P(X) for each value
        System.out.print("\nP(x)\t");
        for(double prob: theoProbs)
            System.out.print(df.format(prob) + "  ");
    }
}