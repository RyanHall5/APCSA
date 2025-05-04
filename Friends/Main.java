package Friends;
/**
 * Programmer:Ryan Hall
 * Program: This program allows the user to enter an undefined number of friends. It then chooses 2 random unique friends to go to the movies with. It then allows the user to turn friends to best friends
 * by referring to them via their index in the friends list. The program removes those friends from the friends list and adds them to the best friends list then displays both to the user.
 * Issues: None
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        ArrayList<String> friends = new ArrayList<String>();

        System.out.println("Welcome! Please enter your friends' first name. Press \"d\" when you are done.");
        String input = reader.next();


        //filling list of friends
        while(!input.equalsIgnoreCase("d")){
            friends.add(input);
            input = reader.next();
        }

        //displaying list of friends
        System.out.println("You have entered" + friends.size() + " friends");
        System.out.println("Here is your list of friends");
        for(int i = 0; i < friends.size(); i++)
            System.out.println((i + 1)+". " + friends.get(i));


        //generating 2 random unqiue friends to go to the movies with
        System.out.println("The two friends that have been randomly chosen to go to the movies with you are: ");
        int rand1 = (int) (Math.random() * friends.size());
        System.out.println(friends.get(rand1));
        int rand2 = (int) (Math.random() * friends.size());
        while(rand2 == rand1)
            rand2 = (int) (Math.random() * friends.size());
        System.out.println(friends.get(rand2));


        //getting list of friends to add to best friends list
        ArrayList<Integer> bestiesIndex = new ArrayList<Integer>();
        System.out.println("Which friends would you like to take off your friend list and add to your best friend list? (Indicate with the number next to each name. Press \"0\" to end)");
        int n = reader.nextInt();
        while(n != 0) {
            bestiesIndex.add(n - 1);
            n = reader.nextInt();
        }

        //sorting bestiesIndex in decreasing order
        bestiesIndex.sort(Collections.reverseOrder());

        //removing best friends from friends list and adding them to besties list
        ArrayList<String> besties = new ArrayList<String>(bestiesIndex.size());
        for(int i = 0; i < bestiesIndex.size(); i++) {
            String bestie = friends.remove((int) bestiesIndex.get(i));
            besties.add(bestie);
        }

        //printing out list of friends
        System.out.println("Here is your list of friends: ");
        for(int i = 0; i < friends.size(); i++)
            System.out.println((i + 1)+". " + friends.get(i));


        //printing out list of best friends
        System.out.println("Here is your list of best friends: ");
        for(int i = 0; i < besties.size(); i++)
            System.out.println((i + 1) + ". " + besties.get(i));
        reader.close();
    }
}