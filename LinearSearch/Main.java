package LinearSearch;
/**
 * Programmer:Ryan Hall
 * Program: This program has the user enter a number and lets the user know if the number exists in the list of birthdays of our APCSA classmates.
 * Issues: None
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reader =  new Scanner(System.in);

        //list of birthdays of  classmates
        int[] birthdays = {13,5,5,11,11,20,7,9,19,4,14,7,2,1,25};

        //getting users number
        System.out.println("Enter a number 1-31: ");
        int n = reader.nextInt();


        //checking if birthday is in list or not
        if(linearSearch(birthdays, n) != -1){
            System.out.println("Birthday Found");
        }
        else{
            System.out.println("Birthday not found in APCSA");
        }

        reader.close();
    }


    //linear search method
    public static int linearSearch(int[] nums, int target){

        //indexing through list
        for(int i = 0; i < nums.length; i++){

            //if target is found
            if (nums[i] == target)
                //return index it was found at
                return i;
        }
        //return -1 if target was not found
        return -1;
    }

}  