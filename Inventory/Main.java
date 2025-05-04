package Inventory;
/**
 * Programmer:Ryan Hall
 * Program: This program tests and implements the inventories class
 * Issues: None
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);


        //initial message
        System.out.println("Hello and welcome!");


        //creating a new inventory
        Inventory myStore = new Inventory("windows", "doors", "keyboards", 10,14,23);

        //displaying the contents of the Inventory
        System.out.println(myStore);

        //reducing a products stock in the inventory
        System.out.println("Reducing this product: windows by 3");
        myStore.sell("windows", 3);
        System.out.println(myStore);

        //restocking an item in the inventory
        System.out.println("Increasing the number of this product: keyboards by 10");
        myStore.restock("keyboards", 10);
        System.out.println(myStore);

        //checking if an item is available
        System.out.println("Checking availability of this product: doors");
        myStore.availability("doors");

        //sorting the inventory
        System.out.println("Sorting the inventory in alphabetical order");
        myStore.sortInventory();
        System.out.println(myStore);

        reader.close();
    }
}