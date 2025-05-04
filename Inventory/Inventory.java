package Inventory;
/**
 * Programmer:Ryan Hall
 * Program: This program creates an "Inventory" either by default or by allowing the user to submit their products and quantities of each. The program contains
 * multiple methods for selling items, restocking items, and sorting the items by alphabetical order. The program is currently fixed to only allow for 3 products at a time.
 * Issues: None
 */
public class Inventory {

    //Instance Variables
    private String[] names;
    private int[] quantities;

    //default constructor
    public Inventory(){
        names = new String[]{"keyboards", "windows", "doors"};
        quantities = new int[]{2,3,4};
    }

    //parameter constructor
    public Inventory(String p1, String p2, String p3, int q1, int q2, int q3){
        names = new String[]{p1,p2,p3};
        quantities = new int[]{q1,q2,q3};
    }


    //prints the inventory
    public String toString(){
        System.out.println("Current Inventory:");
        String s = "";
        for(int i = 0; i < names.length; i++)
            s += names[i] + " - " + quantities[i] + " units\n";
        return s + "\n";
    }


    //selling a specified number of a specified product if the transaction is possible
    //returns if transaction succeeds
    public boolean sell(String s, int n){
        //checking if the product exists in the inventory
        for(int i = 0; i < names.length; i++){
            if(names[i].equals(s)) {
                if(quantities[i] >= n) {
                    quantities[i] -= n;
                    return true;
                }
            }
        }
        return false;
    }

    //adding a specified amount to a specified item if the transaction is possible
    //returns if transaction succeeds
    public boolean restock(String s, int n){
        for(int i = 0; i < names.length; i++){
            if(names[i].equals(s)) {
                quantities[i] += n;
                return true;
            }
        }
        return false;
    }

    //checks if a product is in stock or not
    //returns T/F for if product is available and prints appropriately
    public boolean availability(String s){
        for(int i = 0; i < names.length; i++){
            if(names[i].equals(s)) {
                if(quantities[i] > 0) {
                    System.out.println("There are " + quantities[i] + " " + names[i] + "'s currently available\n");
                    return true;
                }
            }
        }
        System.out.println("Out of stock, sorry");
        return false;
    }



    //sorts the inventory by alphabetical order then prints it
    public void sortInventory(){
        int smallIndex;
        for(int i = 0; i < names.length - 1; i++){
            smallIndex = i;
            for(int j = i; j < names.length; j++){
                if(names[j].compareToIgnoreCase(names[smallIndex]) < 0){
                    smallIndex = j;
                }
            }
            //swapping names
            String temp = names[i];
            names[i] = names[smallIndex];
            names[smallIndex] = temp;

            //swapping corresponding values
            int temp2 = quantities[i];
            quantities[i] = quantities[smallIndex];
            quantities[smallIndex] = temp2;
        }

        for(int i = 0; i < names.length; i++){
            System.out.println(names[i] + ": " + quantities[i]);
        }
        System.out.println();
    }
}