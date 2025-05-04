/**
 * Programmer: Ryan Hall
 * Program Description: This program tests 4 basic programs involving 2-dimensional arrays.
 * Issues: None
 */
import java.io.FileNotFoundException;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {

        Scanner reader = new Scanner(System.in);

        //problem #1
        //Write a program that creates a 2D array of size 3x3 and fills it with user input.
        int[][] arr1 = new int[3][3];
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr1[i].length; j++){
                System.out.println("Enter a number for spot [" + i + "][" + j + "]");
                arr1[i][j] = reader.nextInt();
            }
        }

        //problem #2
        //Modify a 2D array so that all values in the last column are changed to 100.
        for(int i = 0; i < arr1[arr1.length - 1].length; i++){
            arr1[i][arr1.length - 1] = 100;
        }


        //problem #3
        //Write a program that creates a 2D array of size 3×3, fills it with user input, and then calculates and prints the sum of each row.
        int[][] arr2 = new int[3][3];
        for(int i = 0; i < arr2.length; i++){
            int rowSum = 0;
            for(int j = 0; j < arr2[i].length; j++){
                System.out.println("Enter a number for spot [" + i + "][" + j + "]");
                arr2[i][j] = reader.nextInt();
                rowSum+= arr2[i][j];
            }
            System.out.println("Row #" + (i+1) + " sum: " + rowSum);
        }

        //problem #4
        //Write a program that generates a 4×4 2D array filled with random numbers from 1 to 100, then finds and prints the largest element in the array
        int[][] arr3 = new int[4][4];
        for(int i = 0; i < arr3.length; i++){
            for(int j = 0; j < arr3[i].length; j++) {
                int rand = (int) (Math.random() * 100) + 1;
                arr3[i][j] = rand;
            }
        }

        int highI = 0, highJ = 0;
        for(int i = 0; i < arr3.length; i++){
            for(int j = 0; j < arr3[i].length; j++){
                if(arr3[i][j] > arr3[highI][highJ]){
                    highI = i;
                    highJ = j;
                }
            }
        }

        System.out.println(arr3[highI][highJ]);
        reader.close();
    }
}