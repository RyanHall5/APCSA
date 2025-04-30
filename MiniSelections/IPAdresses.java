package MiniSelections;
/**
 * Programmer:Ryan Hall
 * Program: This program allows the user to enter 4 octet's for an IP address and
 * tells the user if they have entered a valid IP address. If not, it displays which octet's are causing the error
 * Issues: None
 */
import java.util.Scanner;

public class IPAdresses {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        int[] octets = new int[4];
        boolean allValid = true;

        //getting 4 octets from user
        for(int i = 0; i < octets.length; i++){
            System.out.println("Please enter octet #" + (i+1));
            octets[i] = reader.nextInt();
        }


        //checking each octet
        for(int i = 0; i < octets.length; i++){
            if(octets[i] < 0 || octets[i] > 255){
                System.out.println("Octet #" + i + " is incorrect");
                allValid = false;
            }
        }

        //printing address if all are valid
        if(allValid)
            System.out.println("IP Address: " + octets[0] + "." + octets[1] + "." + octets[2] + "." + octets[3]);
        reader.close();
    }
}