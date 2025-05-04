package DownOnTheFarm.Part2;
/**
 * Programmer:Ryan Hall
 * Program: This program allows the user to enter a specified number of cows then do various things with the data stored in these cows.
 * Including, finding a cow by name, counting number of cows of a breed, counting number of cows of adult age.
 * Issues: None
 */
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {


        Scanner reader = new Scanner(System.in);


        //random variables
        int numCows, age;
        double weight;
        String name, breed;

        //getting num cows
        System.out.println("How many cows do you have: ");
        numCows = reader.nextInt();

        Cow[] cows = new Cow[numCows];



        //primary loop and controller
        int option = 0;
        while(option != 5){

            option = 0;
            //error checking user input
            while(option > 5 || option < 1) {
                System.out.println("Down on the Farm!");
                System.out.println("1. Enter Cows");
                System.out.println("2. Check Cow Name");
                System.out.println("3. Count adult cows");
                System.out.println("4. Count Breed");
                System.out.println("5. Exit");
                option = reader.nextInt();
            }


            switch(option){
                case 1:
                    //user creating array of cows
                    for (int i = 0; i < cows.length; i++) {
                        System.out.println("Enter Cow #" + (i + 1) + "'s name: ");
                        name = reader.next();
                        System.out.println("Enter " + name + "'s weight: ");
                        weight = reader.nextDouble();
                        System.out.println("Enter " + name + "'s age: ");
                        age = reader.nextInt();
                        System.out.println("Is " + name + " a male? ");
                        boolean male = reader.nextBoolean();
                        System.out.println("Enter " + name + "'s breed: ");
                        breed = reader.next();
                        cows[i] = new Cow(name, weight, age, male, breed);
                    }
                    break;
                case 2: //searching for cow by name
                    System.out.println("Enter the name of the cow you want to find: ");
                    name = reader.next();
                    Cow foundCow = findCow(cows, name);
                    foundCow.displayCow();
                    break;
                case 3://counting number of adult cows
                    System.out.println("You have " + fullGrown(cows) + " adult cows.");
                    break;
                case 4://count number of cows by breed
                    System.out.println("4. Enter breed: ");
                    breed = reader.next();
                    System.out.println("You have " + countBreed(cows, breed) + " " + breed + " cows.");
                    break;


            }



        }


        reader.close();
    }

    //finds a cow by name and return it if found, returns null if cow does not exist
    public static Cow findCow(Cow[] list, String s){
        for(Cow cow : list){
            if(cow.getName().equals(s))
                return cow;
        }
        System.out.println("ERROR: Cow not found");
        return null;
    }

    //counts the number of adult cows in a list of cows
    public static int fullGrown(Cow[] list){
        int count = 0;
        for(Cow cow: list){
            if(cow.getAge() >= 2)
                count+=1;
        }
        return count;
    }

    //counts the number of occurrences of a cow of a specific breed in a list of cows
    public static int countBreed(Cow[] list, String s){
        int count  = 0;
        for(Cow cow : list){
            if(cow.getBreed().equals(s))
                count+=1;
        }
        return count;
    }
}