package Battleship;
/**
 * Programmer: Ryan Hall
 * Program Description: This class contains all the necessary methods and attributes to play the battleship game. The game is played on a 10x10 board from 1-10 and A-J.
 * Player 1 primarily deals with placing ships via addShip() to the shipBoard and Player 2 primarily deals with attacking ships placed by player 1 on shipBoard via fire().
 * displayBoard() is used to show the board with the ships unhidden (shipBoard) whereas toString() is used to show the board Player 2's attacks are recorded on (attackBoard).
 * Issues: None
 */
import java.util.Arrays;
import java.util.Hashtable;

public class Board {

    //instance variables
    String[][] shipBoard;
    String[][] attackBoard;
    boolean destroyerPlaced = false;

    public Board(){

        //creating both boards
        shipBoard = new String[11][11];
        attackBoard = new String[11][11];

        //filling board with "-"
        for(int i = 0; i < 11; i++){
            Arrays.fill(shipBoard[i], "-");
            Arrays.fill(attackBoard[i], "-");
        }

        //changing first index to blank for formatting
        shipBoard[0][0] = " ";
        attackBoard[0][0] = " ";

        //filling 1-10
        for(int i = 1; i < 11; i++){
            shipBoard[0][i] = Integer.toString(i);
            attackBoard[0][i] = Integer.toString(i);
        }

        //filling A-J
        for(int i = 1; i < 11; i++){
            shipBoard[i][0] = Character.toString(i+64);
            attackBoard[i][0] = Character.toString(i+64);
        }
    }

    public String[][] getShipBoard(){return shipBoard;}


    /**
     * Placing boat if it fits in the board with no conflicts
     *
     * @param l     length of the boat
     * @param r     row the boat starts at
     * @param c     column the boat starts at
     * @param h     whether the boat is horizontal or vertical (true=horizontal & false=vertical)
     * @return      true if the boat is successfully places, false if the boat doesn't fit
     */
    public boolean addShip(int l, int r, int c, boolean h){

        //checking to see if boat fits in board and doesn't hit any other boats
        if(h){
            if(c + l > 11)
                return false;
            for(int j = c; j < shipBoard[r].length && j < c + l; j++){
                if(!shipBoard[r][j].equals("-"))
                    return false;
            }
        } else{
            if(r + l > 11)
                return false;
            for(int i = r; i < shipBoard.length && i < r + l; i++){
                if(!shipBoard[i][c].equals("-"))
                    return false;
            }
        }

        //deciding what letter (type boat) based off length of boat
        String letter = switch (l) {
            case 5 -> "C";
            case 4 -> "B";
            case 3 -> "D";
            case 2 -> "P";
            default -> "";
        };

        //making decision for which length 3 boat to place
        if(letter.equals("D")){
            if(destroyerPlaced)
                letter = "S";
            else
                destroyerPlaced = true;
        }

        //placing boat
        for(int i = 0; i < l; i++){
            if(h){shipBoard[r][c] = letter; c++;}
            else{shipBoard[r][c] = letter; r++;}
        }

        //returning true if everything ran successfully
        return true;
    }


    /**
     * Fires a shot at coordinates and returns true if the shot hit a boat
     *
     * @param r     row of the shot
     * @param c     column of the shot
     * @return      True if the shot hit a boat, false if it missed
     */
    public boolean fire(int r, int c){
        //result of the shot as a string 'M' or 'X'
        String result;
        if(shipBoard[r][c].equals("-"))
            result = "M";
        else {
            result = "X";
            shipBoard[r][c] = shipBoard[r][c].toLowerCase(); //changing original board if ship is hit
        }

        //updating attackBoard with 'M' or 'X'
        attackBoard[r][c] = result;

        //returning if shot hit or not
        return result.equals("X");
    }


    /**
     * Returns the number of ships sunk and prints the names of any sunk ships
     *
     * @return      The number of ships that have been sunk
     */
    public int sunkShips(){

        //creating a hashmap to store the number of hits on each boat
        Hashtable<String, Integer> hash = new Hashtable<String, Integer>();
        hash.put("Carrier",0);
        hash.put("Battleship",0);
        hash.put("Destroyer",0);
        hash.put("Submarine",0);
        hash.put("Patrol Boat",0);

        //counting # of not hit spots for each ship
        for(int i = 1; i < shipBoard.length; i++){
            for(int j = 1; j < shipBoard[i].length; j++) {
                if(!shipBoard[i][j].equals("-")){
                    for(String key: hash.keySet()){
                        if(key.substring(0,1).equals(shipBoard[i][j]))
                            hash.put(key, hash.get(key) + 1);
                    }
                }
            }
        }

        //printing out which ships are sunk and counting how many are sunk
        int count = 0;
        for(String key: hash.keySet()){
            if(hash.get(key) == 0) {
                System.out.println(key + " is sunk.");
                count+=1;
            }
        }
        if(count == 0)
            System.out.println("None of the ships have been sunk");

        //returning how many ships have been sunk
        return count;
    }


    /**
     *
     * @return true if all ships have been sunk
     */
    public boolean gameOver(){
        return sunkShips() == 5;
    }


    /**
     * Displays shipBoard to user in nice formatting
     *
     */
    public void displayBoard(){
        for (String[] strings : shipBoard) {
            for (String string : strings)
                System.out.print(string + "  ");
            System.out.println();
        }
    }


    /**
     * Displays attackBoard to user in nice formatting
     *
     * @return      attackBoard as one big string to be printed
     */
    public String toString(){
        String s = "";
        for (String[] strings : attackBoard) {
            for (String string : strings)
                s += string + "  ";
            s += "\n";
        }
        return s;
    }



}