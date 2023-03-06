/**
 * class Player contains the information about the player
 * @author Alyssa Ysabellele Meneses
 * @author Lind Matthew Tan
 * @version 1.0
 */

public class Player {
    private final String NAME;
    private final String COLOR;
    private final int NUMBER;
    private boolean isTurn;

    /**
     * This constructor initializes player name, number and the color of the player's animals
     * @param n player name
     * @param c color of the animal
     * @param t turn bool true if players turn, false if not
     * @param num player number
     */
    public Player(String n, String c, boolean t, int num){
        NAME = n;
        COLOR = c;
        isTurn = t;
        NUMBER = num;
    }

    /**
     * This method returns the name of the player
     * @return name of the player
     */
    public void changeTurn(){
        isTurn = !isTurn;
    }

    /**
     * This method returns the name of the player
     * @return name of the player
     */
    public String getName(){
        return NAME;
    }

    /**
     * This method returns the color of the player's animals
     * @return color of the animals
     */
    public String getColor(){
        return COLOR;
    }

    /**
     * This method returns the player turn
     * @return true if it is the player's turn, false if otherwise
     */
    public boolean getTurn(){
        return isTurn;
    }

    public int getNumber(){
        return NUMBER;
    }

    /**
     * This method returns the player number, name, and color
     * @return player number, name and method
     */
    public String toString(){
        return "Player " + NUMBER + " : " + NAME + " " + "[" + COLOR + "]";
    }

}