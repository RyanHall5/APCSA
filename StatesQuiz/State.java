package StatesQuiz;
import java.util.ArrayList;

public class State {

    private String name;
    private String abbrev;
    private int population;
    private int areaRank;

    //default constructor
    public State(){
        name = null;
        abbrev = null;
        population = -1;
        areaRank = -1;
    }

    //parameter constructor
    public State(String n,String a, int p, int r){
        name = n;
        abbrev = a;
        population = p;
        areaRank = r;
    }


    //accessors
    public String getName(){return name;}
    public String getAbbrev(){return abbrev;}
    public int getPopulation(){return population;}
    public int getAreaRank(){return areaRank;}

    //mutators
    public void setName(String n){name = n;}
    public void setAbbrev(String a){abbrev = a;}
    public void setPopulation(int p){population = p;}
    public void setAreaRank(int r){areaRank = r;}

    //filling a list with data for all 50 states
    public static void fillList(ArrayList<State> states){
        states.add(new State("Alabama", "AL", 4949697, 30));
        states.add(new State("Alaska", "AK", 720763, 1));
        states.add(new State("Arizona", "AZ", 7640796, 6));
        states.add(new State("Arkansas", "AR", 3042017, 29));
        states.add(new State("California", "CA", 39664128, 3));
        states.add(new State("Colorado", "CO", 5961083, 8));
        states.add(new State("Connecticut", "CT", 3546588, 48));
        states.add(new State("Delaware", "DE", 998619, 49));
        states.add(new State("Florida", "FL", 22177997, 22));
        states.add(new State("Georgia", "GA", 10936299, 24));
        states.add(new State("Hawaii", "HI", 1401709, 43));
        states.add(new State("Idaho", "ID", 1896652, 14));
        states.add(new State("Illinois", "IL", 12518071, 25));
        states.add(new State("Indiana", "IN", 6842385, 38));
        states.add(new State("Iowa", "IA", 3174426, 26));
        states.add(new State("Kansas", "KS", 2919179, 15));
        states.add(new State("Kentucky", "KY", 4487233, 37));
        states.add(new State("Louisiana", "LA", 4616106, 31));
        states.add(new State("Maine", "ME", 1359677, 39));
        states.add(new State("Maryland", "MD", 6075314, 42));
        states.add(new State("Massachusetts", "MA", 6922107, 44));
        states.add(new State("Michigan", "MI", 9995212, 11));
        states.add(new State("Minnesota", "MN", 5739781, 12));
        states.add(new State("Mississippi", "MS", 2961536, 32));
        states.add(new State("Missouri", "MO", 6184843, 21));
        states.add(new State("Montana", "MT", 1093117, 4));
        states.add(new State("Nebraska", "NE", 1960790, 16));
        states.add(new State("Nevada", "NV", 3238601, 7));
        states.add(new State("New Hampshire", "NH", 1378449, 46));
        states.add(new State("New Jersey", "NJ", 8870685, 47));
        states.add(new State("New Mexico", "NM", 2109093, 5));
        states.add(new State("New York", "NY", 19223191, 27));
        states.add(new State("North Carolina", "NC", 10807491, 28));
        states.add(new State("North Dakota", "ND", 774008, 19));
        states.add(new State("Ohio", "OH", 11727377, 34));
        states.add(new State("Oklahoma", "OK", 4007179, 20));
        states.add(new State("Oregon", "OR", 4325290, 9));
        states.add(new State("Pennsylvania", "PA", 12805190, 33));
        states.add(new State("Rhode Island", "RI", 1062583, 50));
        states.add(new State("South Carolina", "SC", 5342388, 40));
        states.add(new State("South Dakota", "SD", 902542, 17));
        states.add(new State("Tennessee", "TN", 7001803, 36));
        states.add(new State("Texas", "TX", 30097526, 2));
        states.add(new State("Utah", "UT", 3363182, 13));
        states.add(new State("Vermont", "VT", 622882, 45));
        states.add(new State("Virginia", "VA", 8638218, 35));
        states.add(new State("Washington", "WA", 7887965, 18));
        states.add(new State("West Virginia", "WV", 1755715, 41));
        states.add(new State("Wisconsin", "WI", 5867518, 23));
        states.add(new State("Wyoming", "WY", 582233, 10));
    }

    //prints out data in state
    //ex output: Obj State: {name: Alabama, abbrev: AL, population: 4949697, areaRank: 30}
    public String toString() {
        return "\nObj State: [name: " + name + ", abbrev: " + abbrev + ", population: " + population + ", areRank: " + areaRank + "}";
    }
}