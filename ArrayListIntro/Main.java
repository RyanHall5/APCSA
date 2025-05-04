package ArrayListIntro;
/**
 * Programmer:Ryan Hall
 * Program: This program tests various ArrayList methods on 3 different ArrayList of 3 different types: int, String, and Cow
 * Issues: None
 */
import java.util.ArrayList;
public class Main{
public static void main(String[] args) {

    ArrayList<Integer> grades = new ArrayList<Integer>();
    ArrayList<String> friends = new ArrayList<String>();
    ArrayList<Cow> cows = new ArrayList<Cow>();

    //filling grades
    for (int i = 100; i >= 90; i -= 2)
        grades.add(i);

    //filling friends
    friends.add("Ryan");
    friends.add("Evan");
    friends.add("Matt");
    friends.add("Kyle");
    friends.add("Cole");

    //filling cows
    cows.add(new Cow("Alexander", 120.0, 2, true, "Angus"));
    cows.add(new Cow("Gerald", 80.0, 3, true, "Beefalo"));
    cows.add(new Cow("Lucas", 190.0, 5, true, "Angus"));
    cows.add(new Cow("Angel", 60.0, 1, false, "Beefalo"));
    cows.add(new Cow("Lucy", 150.0, 7, false, "Angus"));


    //Testing method 1 for all lists: .size()
    System.out.println("Testing .size() method: ");
    System.out.println("Size of grades: " + grades.size());
    System.out.println("Size of friends: " + friends.size());
    System.out.println("Size of cows: " + cows.size());

    //clearing line
    System.out.println();

    //Testing method 2 for all lists: .add()
    System.out.println("Testing .add() method: ");
    System.out.println("Adding grade of 85 to grade: ");
    grades.add(85);
    System.out.println(grades);
    System.out.println("Adding friend \"Jeremy\" to friends: ");
    friends.add("Jeremy");
    System.out.println(friends);
    System.out.println("Adding cow \"Jeff\" to cows: ");
    cows.add(new Cow("Jeff", 130.0, 3, true, "Beefalo"));
    for (Cow c : cows)
        System.out.println(c);

    //clearing line
    System.out.println();

    //Testing method 3 .get()
    System.out.println("Testing .get() method");
    System.out.println("Getting index 2 from grades: ");
    System.out.println(grades.get(2));
    System.out.println("Getting index 3 from friends: ");
    System.out.println(friends.get(3));
    System.out.println("Getting index 1 from cows: ");
    System.out.println(cows.get(1));

    //clearing line
    System.out.println();

    //Testing method 4 .set()
    System.out.println("Testing .set() method: ");
    System.out.println("Setting index 2 of grades to 93: ");
    grades.set(2, 93);
    System.out.println(grades);
    System.out.println("Setting index 3 of friends to Bryan");
    friends.set(3, "Bryan");
    System.out.println(friends);
    System.out.println("Setting index 1 of cows to BigAngus");
    cows.set(1, new Cow("BigAngus", 220.0, 6, true, "Angus"));
    for(Cow c: cows)
        System.out.println(c);

    //clearing line
    System.out.println();

    //Testing method 5 .remove()
    System.out.println("Testing .remove() method");
    System.out.println("Removing index 1 from grades: ");
    grades.remove(1);
    System.out.println(grades);
    System.out.println("Removing index 1 from friends: ");
    friends.remove(1);
    System.out.println(friends);
    System.out.println("Removing index 1 from cows: ");
    cows.remove(1);
    for (Cow c : cows)
        System.out.println(c);

    //clearing line
    System.out.println();

    //Testing method 6 .clear()
    System.out.println("Testing .clear() method");
    System.out.println("Clearing grades list: ");
    grades.clear();
    System.out.println(grades);
    System.out.println("Clearing friends list: ");
    friends.clear();
    System.out.println(friends);
    System.out.println("Clearing cows list: ");
    cows.clear();
    System.out.println(cows);
    }
}