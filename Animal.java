/** This class is the parent class for all the animal subclasses (Elephant, Mouse, animalCanJump)
* @author Alyssa Ysabelle Meneses
* @author Lind Matthew Tan
* @version 1.0
*/
public class Animal {
    private final String NAME;
    private final int RANK;
    private final String EMOJI;
    private final Player OWNER;
    private boolean isTrapped = false;

    /**
     * This constructor initializes the name, rank, emoji (output of the console), and owner of the animal
     * @param n     name of the animal
     * @param r     rank of the animal
     * @param e     emoji (String output of the program) //might be removed after the implementation of GUI
     * @param player owner of the animal (player number)
     */
    public Animal(String n, int r, String e, Player player){
        NAME = n;
        RANK = r;
        EMOJI = e;
        OWNER = player;
    }

    /**
     * This method returns the rank of the animal
     * @return rank of the animal
     */
    public int getRank(){
        return RANK;
    }

    /**
     * This method returns the emoji/the string seen on the board
     * @return the emoji/string seen on the console board
     */
    public String getEmoji(){
        return EMOJI;
    }

    /**
     * This method returns the name of the player
     * @return name of the player
     */
    public String getName(){
        return NAME;
    }

    /**
     * This method returns the owner of the animal
     * @return object Player
     */
    public Player getOwner(){
        return OWNER;
    }

    /**
     * This method returns if the animal is trapped or not
     * @return true if the animal is trapped, false if otherwise
     */
    public boolean isTrapped(){
        return isTrapped;
    }

    /**
     * This method sets the value of the variable isTrapped
     */
    public void changeTrapped(){
        isTrapped = !isTrapped;
    }

    /**
     * This method checks if the move of the player is going 1 unit up, down, left, or right (UDLR)
     * @param sR the Row position of the mover on the gameboard
     * @param sC the Col position of the mover on the gameboard
     * @param dR the Row position of the destination on the gameboard
     * @param dC the Col position of the destination on the gameboard
     * @return true if the move is valid, false if otherwise
     */
    public static boolean isUDLRmove(int sR, int sC, int dR, int dC){
        boolean val = false;

        if((sR-1 == dR) && (sC == dC)){ //UP
            System.out.println("UP!");
            val = true;
        }
        else if((sR+1 == dR) && (sC == dC)){ //DOWN
            System.out.println("DOWN!");
            val = true;
        }
        else if((sR == dR) && (sC-1 == dC)){ //LEFT
            System.out.println("LEFT!");
            val = true;
        }
        else if((sR == dR) && (sC+1 == dC)){ //RIGHT
            System.out.println("RIGHT!");
            val = true;
        }
        else{
            System.out.println("INVALID TILE (not UDLR)");
        }
        return val;
    }
    
   
    /**
     * This method checks if the move of the player is valid
     * @param gameboard 2D array of Tiles in the gameboard
     * @param sR the Row position of the mover on the gameboard
     * @param sC the Col position of the mover on the gameboard
     * @param dR the Row position of the destination on the gameboard
     * @param dC the Col position of the destination on the gameboard
     * @return true if the move is valid, false if otherwise
     */
    public boolean isValidMove(Tile[][] gameboard, int sR, int sC, int dC, int dR){
        boolean val = false;

        if(!(gameboard[dR][dC].getTerrain() instanceof River)){
            if(gameboard[dR][dC].getAnimal()==null){
                val = isUDLRmove(sR, sC, dR, dC);
            }
            else if(gameboard[sR][sC].getAnimal().getRank() >= gameboard[dR][dC].getAnimal().getRank() || gameboard[dR][dC].getAnimal().isTrapped()){
                val = isUDLRmove(sR, sC, dR, dC);
            }
            else{
                System.out.println("INVALID MOVE moving a normal Animal");
            }
        
            if (gameboard[sR][sC].getTerrain() instanceof Trap  && val==true){
                gameboard[sR][sC].getAnimal().changeTrapped();
                System.out.println(sR+" "+sC+" trap status changed");
            }
            else if (gameboard[dR][dC].getTerrain() instanceof Trap && val==true){
                if(((Trap)gameboard[dR][dC].getTerrain()).getPlayer() != gameboard[sR][sC].getAnimal().getOwner()){
                    gameboard[sR][sC].getAnimal().changeTrapped();
                    System.out.println(sR+" "+sC+" trap status changed");
                }
            }
        }
        else
            System.out.println("INVALID you are trying to traverse water");
        return val;

    }
}
