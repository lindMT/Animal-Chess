/** This class is a subclass for Animal
* @author Alyssa Ysabelle Meneses
* @author Lind Matthew Tan
* @version 1.0
*/
public class Elephant extends Animal{
    /**
     * This constructor initializes the name, rank, emoji (output of the console), and owner of the animal
     * @param n     name of the animal
     * @param r     rank of the animal
     * @param e     emoji (String output of the program) //might be removed after the implementation of GUI
     * @param player owner of the animal (player number)
     */
    public Elephant(String n, int r, String e, Player player) {
        super(n, r, e, player);
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
    @Override
    public boolean isValidMove(Tile[][] gameboard, int sR, int sC, int dC, int dR){
        boolean val = false;
        if(gameboard[dR][dC].getAnimal() instanceof Mouse || gameboard[dR][dC].getTerrain() instanceof River){
            val = false;
        }
        else{
            val=isUDLRmove(sR, sC, dR, dC);        
        }
        if(val==false){
            System.out.println("INVALID MOVE moving an Elephant");
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
        return val;
    }
}
