package Library;
import java.util.ArrayList;

public class Person {

    //instance vars
    private String name;
    private int id;
    private String phoneNum;

    //empty book list
    private ArrayList<Book> bookList = new ArrayList<Book>();

    //default constructor
    public Person(){
        name = "";
        id = -1;
        phoneNum = "";
    }

    //parameter constructor
    public Person(String n, int num, String p){
        name = n;
        id = num;
        phoneNum = p;
    }

    //Gets and Sets for each variable
    public String getName(){return name;}
    public void setName(String n){name = n;}

    public int getID(){return id;}
    public void setID(int num){id = num;}

    public String getPhoneNum(){return phoneNum;}
    public void setPhoneNum(String p){phoneNum = p;}

    public ArrayList<Book> getBookList(){return bookList;}

    //Methods to edit bookList
    public void CheckOut(Book b){
        bookList.add(b);
        bookList.getLast().setOwner(Person.this);
    }
    public void removeBook(Book b){bookList.remove(b);}

    //additional methods
    public void printBooks(){
        for(Book b: bookList)
            System.out.println(b.getTitle());
    }

    //display method
    public void printPerson(){
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Phone Number: " + phoneNum);
        System.out.print("Books: ");
        for(Book b: bookList)
            System.out.print(b.getTitle() + " ");
    }
}