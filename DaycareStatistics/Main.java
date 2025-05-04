package DaycareStatistics;
/**
 * Programmer: Ryan Hall
 * Program Description: This program reads a csv file contains students in a daycare and stores all of their data in an arraylist of Student
 * objects. The program performs various tasks using the data from these students including: outputting names, calculating averages, sorting, etc.
 * Issues: None
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        //declaring file
        Scanner infile = new Scanner (new FileReader("Data.csv"));
        infile.useDelimiter(",");

        //global list of all students in daycare
        ArrayList<Student> daycare = new ArrayList<Student>();

        //reading data from file into list
        while(infile.hasNext()){

            String name = infile.next();
            int age = infile.nextInt();
            String gen = infile.next();
            String town = infile.next();
            int days = Integer.parseInt(infile.next());
            String phone = infile.nextLine().substring(1);

            daycare.add(new Student(name, age, gen, town, days, phone));
        }

        System.out.println("Task 1: Display the student names");
        displayNames(daycare);
        System.out.println("\n");

        System.out.println("Task 2: Display the average age of the female children and the average age of the male children");
        displayAvgAges(daycare);
        System.out.println("\n");

        System.out.println("Task 3: Display how many students are from each of the towns with a histogram");
        displayHometownHistogram(daycare);
        System.out.println("\n");

        System.out.println("Task 4: How much does the daycare make in income in one week?");
        displayIncome(daycare);
        System.out.println("\n");

        System.out.println("Task 5: Give the choice of a student from a list, look up phone number of a user inputted number.");
        studentLookup(daycare);
        System.out.println("\n");

        System.out.println("Task 6: Use a sorting algorithm to sort the students in order of their last name");
        sortStudents(daycare);

        infile.close();
    }

    //Prints name of every student in parameter list
    public static void displayNames(ArrayList<Student> list){
        for(Student s: list)
            System.out.println(s.getName());
    }

    //prints average age of both genders
    public static void displayAvgAges(ArrayList<Student> list){
        int mTotal = 0,mCount = 0, fTotal = 0, fCount = 0;
        for(Student s: list){
            if(s.getGender().equals("M")) {
                mTotal += s.getAge();
                mCount++;
            } else {
                fTotal += s.getAge();
                fCount++;
            }
        }
        System.out.println("The average age of the females is: " + fTotal / fCount);
        System.out.println("The average age of the males is: " + mTotal / mCount);
    }



    //displays how many students are from each town
    public static void displayHometownHistogram(ArrayList<Student> list){
        String spaces = "           ";
        Hashtable<String, Integer> towns = new Hashtable<>();
        for(Student s: list){
            if(towns.contains(s.getHometown()))
                towns.put(s.getHometown(), towns.get(s.getHometown()) + 1);
            else
                towns.put(s.getHometown(), 1);
        }

        System.out.println("Histogram of Towns: ");
        for(String town: towns.keySet()){
            String stars = new String(new char[towns.get(town)]).replace("\0", "*");
            System.out.println(town + ": " + spaces.substring(town.length()) + stars);
        }
    }


    //calculates daycares weekly income
    public static void displayIncome(ArrayList<Student> list){
        int dayTotal = 0;
        for(Student s: list){
            switch(s.getAge()){
                case 1: dayTotal += 35;
                case 2: dayTotal += 30;
                case 3: dayTotal += 25;
                case 4: dayTotal += 20;
                case 5: dayTotal += 15;
            }
        }
        System.out.println("The total weekly income for the daycare is: $" + dayTotal * 7);
    }


    //displays student lookup then specific student chosen
    public static void studentLookup(ArrayList<Student> list){
        Scanner reader = new Scanner(System.in);
        for(int i = 0; i < list.size(); i++)
            System.out.println((i + 1) + ") " + list.get(i).getName());
        int index = reader.nextInt() - 1;
        System.out.println(list.get(index));
        reader.close();
    }

    public static void sortStudents(ArrayList<Student> list){
        int smallIndex;
        for(int i = 0; i < list.size(); i++){
            smallIndex = i;
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(smallIndex).getLastName().compareTo(list.get(j).getLastName()) > 0)
                    smallIndex = j;
            }
            Student temp = list.get(smallIndex);
            list.set(smallIndex, list.get(i));
            list.set(i, temp);
        }

        for(Student s: list) {
            System.out.print(s.getName() + ", ");
            System.out.print(s.getAge() + ", ");
            System.out.print(s.getGender() + ", ");
            System.out.print(s.getHometown() + ", ");
            System.out.println(s.getPhoneNum());
        }
    }
}