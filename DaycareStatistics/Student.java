package DaycareStatistics;
/**
 * Programmer: Ryan Hall
 * Program Description: This Class stores the data as well as a toString function for the students in a daycare
 * Issues: None
 */
public class Student {

    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String hometown;
    private int daysAttending;
    private String phoneNum;


    //default constructor (shouldn't need to use)
    public Student(){
        firstName = null;
        lastName = null;
        age = -1;
        gender = null;
        hometown = null;
        daysAttending = -1;
        phoneNum = null;
    }

    //parameter constructor
    public Student(String name, int age, String gender, String hometown, int daysAttending, String phoneNum){
        firstName = name.substring(0, name.indexOf(" "));
        lastName = name.substring(name.indexOf(" ") + 1);
        this.age = age;
        this.gender = gender;
        this.hometown = hometown;
        this.daysAttending = daysAttending;
        this.phoneNum = phoneNum;
    }

    //accessors
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getName(){return firstName + " " + lastName;}
    public String getGender(){return gender;}
    public String getHometown(){return hometown;}
    public String getPhoneNum(){return phoneNum;}
    public int getAge(){return age;}
    public int getDaysAttending(){return daysAttending;}

    //mutators
    public void setFirstName(String s){firstName = s;}
    public void setLastName(String s){lastName = s;}
    public void setGender(String s){gender = s;}
    public void setHometown(String s){hometown = s;}
    public void setPhoneNum(String s){phoneNum = s;}
    public void setAge(int n){age = n;}
    public void setDaysAttending(int n){age = n;}

    public String toString(){
        return "Name: " + getName() + "\n" +
                "Age: " + age + "\n" +
                "Hometown: " + hometown + "\n" +
                "Days Attending Daycare: " + daysAttending + "\n" +
                "Phone Number: " + phoneNum;
    }
}