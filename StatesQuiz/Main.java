package StatesQuiz;
/**
 * Programmer: Ryan Hall
 * Program Description: This program allows the user to play a multiple choice quiz game about the 50 states. I extremely overengineered the program so it is very dynamic and easily scalable.
 * The program uses a lot of global variables to reduce repetitive code by using methods for the majority of the program's functionality.
 * Issues: None
 */
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    //Finals that can change with the program
    public static final int NUMQUESTIONS = 5;
    public static final int NUMOPTIONS = 4;

    //Global variables used in methods so the code can be less repetitive
    public static char[] answerIndexes = new char[NUMQUESTIONS]; //The answer to each question (ABCD)
    public static char[] responses = new char[NUMQUESTIONS]; //What the user answered (ABCD)
    public static State[][] questionsData = new State[NUMQUESTIONS][NUMOPTIONS]; //The options to each question
    public static ArrayList<State> states = new ArrayList<State>(); //Data of 50 states
    public static int currQuest = 0; //Which question # the program is on (0 indexed)
    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {

        //Filling 'states' with state data
        State.fillList(states);

        //Game Welcome
        System.out.println("Welcome to our state quiz game: ");
        System.out.println("You will be given 5 multiple choice questions about the states");
        System.out.println("Choose the correct letter and get a point!");

        genQuestionData(currQuest, questionsData[currQuest]); //need to generate initially so 'questions' is able to compile
        String[] questions = {
                "1. Which of the following states has an abbreviate of: " + questionsData[0][answerIndexes[0] - 65].getAbbrev(),
                "2. Of the following 4 states, which has the largest population?",
                "3. Of the following 4 states, which has the smallest population?",
                "4. Of the following states, which is the largest in land size?",
                "5. Of the following states, which is the smallest in land size"
        };

        //displaying all the questions
        for(int i = 0; i < NUMQUESTIONS; i++){
            genQuestionData(currQuest, questionsData[currQuest]);
            System.out.println(questions[currQuest]);
            displayQuestion(currQuest, questionsData[currQuest]);
        }

        //displaying final results
        System.out.println("Thank you for playing!");
        System.out.print("Your score is: ");
        int count = 0;
        for(int i = 0; i < responses.length; i++){
            if(responses[i] == answerIndexes[i])
                count += 1;
        }
        System.out.println(count);
    }

    /**
     * Randomly generate the choices and determine the correct answer for a question
     *
     * @param n         The question number
     * @param options   The list for the data to be stored
     */
    public static void genQuestionData(int n, State[] options){
        ArrayList<Integer> temp = randomIndexes(0,50,4);
        int val = 0;
        for(int i = 0; i < options.length; i++){
            options[i] = states.get(temp.get(i));
            switch(n + 1){
                case 1:
                    val = (int) (Math.random() * NUMOPTIONS); break;
                case 2:
                    if(options[i].getPopulation() > options[val].getPopulation()){val = i;} break;
                case 3:
                    if(options[i].getPopulation() < options[val].getPopulation()){val = i;} break;
                case 4:
                    if(options[i].getAreaRank() < options[val].getAreaRank()){val = i;} break;
                case 5:
                    if(options[i].getAreaRank() > options[val].getAreaRank()){val = i;} break;
                default:
                    System.out.println("ERROR: Uh... wrong input for n."); break;
            }
        }
        answerIndexes[n] = (char) (val + 65);
    }

    /**
     * Generates random non-repeating numbers in the range [start,end)
     *
     * @param start     start of range of returnable values (inclusive)
     * @param end       end of range of returnable values (exclusive)
     * @param count     # of values to be generated
     * @return          unique generated values stored in an ArrayList
     */
    public static ArrayList<Integer> randomIndexes(int start, int end, int count){
        int rand = (int) (Math.random() * end) + start;
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        for(int i = 0; i < count; i++){
            while(indexes.contains(rand))
                rand = (int) (Math.random() * end) + start;
            indexes.add(rand);
        }
        return indexes;
    }

    /**
     * Displays the current question + choices + records answer to question + increments question number
     *
     * @param n         The question number
     * @param options   The list containing the question's data
     */
    public static void displayQuestion(int n, State[] options){
        for(int i = 0; i < options.length; i++)
            System.out.println((char) (i+65) + ". " + options[i].getName());
        responses[n] = reader.next().toUpperCase().charAt(0); //converts letter into uppercase char value
        if(responses[n] == answerIndexes[n])
            System.out.println("Yes! You got question #" + (n+1) + " correct.");
        else
            System.out.println("Sorry, the correct answer was: " + answerIndexes[n]);
        currQuest += 1;
    }
}