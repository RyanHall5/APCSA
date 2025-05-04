package CustomInheritance;
/**
 * Programmer: Ryan Hall
 * Program Description: This program tests the classes created using inheritance in the StarWarsCharacter file
 * Issues: None
 */
import java.util.ArrayList;

public class Main{
    public static void main(String[] args)  {

        //creating list of characters
        ArrayList<StarWarsCharacter> list = new ArrayList<StarWarsCharacter>();
        list.add(new StarWarsCharacter("Bob", 1234));
        list.add(new StarWarsCharacter("Alexander", 5000));
        list.add(new Rebel("R2D2", 400, true));
        list.add(new Rebel("Jeffery", 7000, false));
        list.add(new Jedi("Ahsoka Tano", 99999, true, "Green"));

        StarWarsCharacter guy1 = new Rebel("Wedge Antilles", 4321, false);//cloaking
        StarWarsCharacter guy2 = new Jedi("Luke", 10000, true, "Blue");//cloaking
        StarWarsCharacter guy3 = new Jedi("Mace Windu", 100000, true, "Purple");//cloaking
        StarWarsCharacter guy4 = guy2;//aliasing
        StarWarsCharacter guy5 = guy1;//aliasing

        list.add(guy1);
        list.add(guy2);
        list.add(guy3);
        list.add(guy4);
        list.add(guy5);

        //displaing all characters via toString
        System.out.println("Displaying all characters in list via toString:\n");
        for(int i = 1; i <= list.size(); i++){
            System.out.println(i + ". " + list.get(i - 1));
        }


        //testing equals for jedi and rebel which by comparison tests starWarsCharacter equals method
        System.out.println("\n\n\n");
        System.out.println("Testing .equals methods: ");
        System.out.println();

        System.out.println("Character 6 and 10 are the same (True/False): " + list.get(5).equals(list.get(9)));
        System.out.println("Character 7 and 9 are the same (True/False): " + list.get(6).equals(list.get(8)));
        System.out.println("Character 1 and 2 are the same (True/False): " + list.get(0).equals(list.get(2)));


        //testing a few of the methods
        System.out.println("\n\n\n");
        System.out.println("Bob and Luke both worked and gained $100. Here are their new values: ");
        list.get(0).work(100);
        list.get(6).work(100);//this also changes the copy of luke in index 8
        System.out.println(list.get(0));
        System.out.println(list.get(6));

        System.out.println("\n\n\n");
        System.out.println("Ashoka is feeling generous so she donates $1000 to the rebellion. Here are her new values: ");
        list.get(4).donate(1000);
        System.out.println(list.get(4));
    }
}