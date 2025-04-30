package Library;
public class Book {

    //instance vars
    private String title;
    private String author;
    private String isbn;
    private Person owner;

    //default constructor
    public Book(){
        title = "N/A";
        author = "N/A";
        isbn = "N/A";
        owner = null;
    }

    //parameter constructor
    public Book(String t, String a, String i, Person o){
        title = t;
        author = a;
        isbn = i;
        o.CheckOut(Book.this);
    }

    //parameter constructor without owner
    public Book(String t, String a, String i){
        title = t;
        author = a;
        isbn = i;
    }

    public String getTitle(){return title;}
    public void setTitle(String t){title = t;}

    public String getAuthor(){return author;}
    public void setAuthor(String a){author = a;}

    public String getIsbn(){return isbn;}
    public void setIsbn(String i){isbn = i;}

    public Person getOwner(){return owner;}
    public void setOwner(Person o){owner = o;}

    public void printBook(){
        System.out.println("title: " + title);
        System.out.println("author: " + author);
        System.out.println("isbn: " + isbn);
        System.out.println("owner: " + owner.getName());
    }
}