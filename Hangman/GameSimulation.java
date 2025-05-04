package Hangman;
/**
 * Programmer:Ryan Hall
 * Program: This class allows the user to create a "game" in the main program and play the traditional hangman game.
 * A random word is generated from the list of predetermined words in the class then the user must attempt to guess the letters of the word.
 * The class rejects repeat guesses, notifying the user if they were right or wrong, notifies the user if they won or lost,
 * Keeps track of letters guessed in alphabetical order, accepts case-insensitive input, and displays the actual hangman as the game goes on.
 * Issues: None
 */
import java.util.ArrayList;

public class GameSimulation {

    private String word;
    private String displayWord;
    private int guessesLeft;
    private ArrayList<String> guessedLetters = new ArrayList<String>();
    private String[] wordList = {"COMPUTER", "TRAFFIC", "STROKE", "WISECRACK", "STAND", "LOST", "ABRACADABRA", "KEYBOARD", "INTELLIGENT", "MAXIMUM" };
    private boolean gameOver;
    private boolean gameWon;

    //default constructor
    public GameSimulation(){

        //generating random word from wordlist
        int rand = (int) (Math.random() * wordList.length);
        word = wordList[rand];

        //creating blank word
        displayWord = new String(new char[word.length()]).replace("\0", "*");

        guessesLeft = 5;
        gameOver = false;
        gameWon = false;
    }

    //parameter constructor
    public GameSimulation(String s){
        word = s;
        displayWord = new String(new char[word.length()]).replace("\0", "*");
        guessesLeft = 5;
        gameOver = false;
        gameWon = false;
    }


    //accessors
    public boolean getGameOver(){return gameOver;}
    public boolean getGameWon(){return gameWon;}
    public String getWord(){return word;}





    //displaying primary text of the game
    public void displayGame(){
        System.out.println("Here's what you have so far: " + displayWord);
        System.out.println("You have " + guessesLeft + " guesses left");
        System.out.print("Here are the letters you have guessed so far: ");
        displayGuessedLetters();
        System.out.println("What letter would you like to guess next?");
    }




    //updating the whole game dependent on the user's guess
    public void updateGame(String s){

        //making code case-insensitive
        s = s.toUpperCase();

        //adding letter to list of guessed letters, if it has not already been guessed
        if(!guessedLetters.contains(s)) {
            guessedLetters.add(s);
            guessedLetters.sort(String.CASE_INSENSITIVE_ORDER);
        }
        else {
            System.out.println("You've already guessed this letter.");
            return;
        }

        //if the word contains the letter, reveal everywhere the letter is in the word
        if(word.contains(s)){
            System.out.println("CORRECT!!!");
            for(int i = 0; i < word.length(); i++){
                if(word.substring(i, i + 1).equals(s))
                    displayWord = displayWord.substring(0,i) + s + displayWord.substring(i + 1);
            }
        }
        else{//if the guess was incorrect
            System.out.println("I'm sorry...");
            guessesLeft-=1;
        }

        //displaying the actual hangman; argument is whether the guess was correct or not
        displayHangMan(!word.contains(s));

        //checking if the game has ended or been won
        if(guessesLeft == 0)
            gameOver = true;
        else if(!displayWord.contains("*")) {
            gameOver = true;
            gameWon = true;
        }
    }


    //method for displaying the previously guessed letters in a neat way
    public void displayGuessedLetters(){
        if(guessedLetters != null){
            for (String guessedLetter : guessedLetters) {
                System.out.print(guessedLetter + " ");
            }
        }
        System.out.println();
    }


    //initial structure of hangman object without the actual man
    String[] hangManLines = {
            "        ____________________________",//1
            "        |                          |",//2
            "        |                          |",//3
            "        |",//4
            "        |",//5
            "        |",//6
            "        |",//7
            "        |",//8
            "        |",//9
            "        |",//10
            "        |",//11
            "        |",//12
            "        |",//13
            "        |",//14
            "__________________"//15
    };
    //displaying the big actual hangman and updating the display dependent upon the number of incorrect guesses
    public void displayHangMan(boolean incorrect){
        if (incorrect) {
            switch (Math.abs(guessesLeft - 5)) {
                case 1:
                    hangManLines[3] += "                         ***";
                    hangManLines[4] += "                        *   *";
                    hangManLines[5] += "                         ***";
                    break;
                case 2:
                    hangManLines[6] += "                   \\      |";
                    hangManLines[7] += "                    \\_____|";
                    break;
                case 3:
                    hangManLines[6] += "      /";
                    hangManLines[7] += "_____/";
                    break;
                case 4:
                    hangManLines[8] += "                          |";
                    hangManLines[9] += "                          |";
                    hangManLines[10] += "                          |";
                    hangManLines[11] += "                         /";
                    hangManLines[12] += "                        /";
                    hangManLines[13] += "                    ___/";
                    break;
                case 5:
                    hangManLines[11] += "\\";
                    hangManLines[12] += "  \\";
                    hangManLines[13] += "    \\___";
                    break;
            }
        }
        for(String line : hangManLines)
            System.out.println(line);

    }
}