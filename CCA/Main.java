package CCA;
/**
 * Programmer:Ryan Hall
 * Program: This program tests all of my mini programs from the CCA
 * Issues: None
 */
public class Main{
public static void main(String[] args) {

    int[] arr = {1,2,3,4,5,6,7,8,9,543,5,7,25,65,657,5,7,4};
    String str = "Balloons";
    String[] names = {"word1","word2","word3","word3","word3", "word4"};

    System.out.println("Program #1: ");
    System.out.println("Number of odds in arr: " + countOdds(arr));

    System.out.println("Program #2: ");
    reverseArray(arr);
    System.out.println("Reverse of arr: ");
    for(int n: arr)
        System.out.print(n + ",");

    System.out.println("Program #3: ");
    System.out.println("str has repeats: " + hasRepeat(str));

    System.out.println("Program #4: ");
    System.out.println("names contains 3 consecutive words: " + ThreeWords(names));

    System.out.println("Program #5: ");
    boolean var = ThreeWords(names);
    System.out.println("Storing ThreeWords result in variable: " + var);
    }

    //method #1
    //counts number of odds in array
    public static int countOdds(int[] arr){
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 == 1)
                count+=1;
        }
        return count;
    }

    //method #2
    //reverses array of ints in place
    public static void reverseArray(int[] arr){
        int low = 0, high = arr.length - 1;
        while(low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low += 1;
            high -= 1;
        }
    }

    //method #3
    //checks is string has repeating letters
    public static boolean hasRepeat(String s){
        for(int i = 1; i < s.length(); i++){
            if(s.substring(i-1,i).equals(s.substring(i,i+1)))
                return true;
        }
        return false;
    }

    //method #4
    //checks if list of strings has 3 consecutive words
    public static boolean ThreeWords(String[] arr){
        for(int i = 2; i < arr.length; i++){
            if(arr[i].equals(arr[i-2]) && arr[i].equals(arr[i-1]))
                return true;
        }
        return false;
    }



}