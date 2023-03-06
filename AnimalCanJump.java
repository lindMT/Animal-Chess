/** This class is a subclass for Animal
* @author Alyssa Ysabelle Meneses
* @author Lind Matthew Tan
* @version 1.0
*/
public class AnimalCanJump extends Animal{
    /**
     * This constructor initializes the name, rank, emoji (output of the console), and owner of the animal
     * @param n     name of the animal
     * @param r     rank of the animal
     * @param e     emoji (String output of the program) //might be removed after the implementation of GUI
     * @param player owner of the animal (player number)
     */
    public AnimalCanJump(String n, int r, String e, Player player) {
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

        if(gameboard[dR][dC].getTerrain() instanceof River){
            return false;
        }

        if(gameboard[dR][dC].getAnimal()==null && !(gameboard[dR][dC].getTerrain() instanceof River)){
            if(validJump(gameboard, sR,sC,dR,dC) || isUDLRmove(sR, sC, dR, dC)){
                val= true;
            }

        }

        else if((gameboard[sR][sC].getAnimal().getRank() >= gameboard[dR][dC].getAnimal().getRank() || gameboard[dR][dC].getAnimal().isTrapped())
        && (validJump(gameboard, sR,sC,dR,dC) || isUDLRmove(sR, sC, dR, dC))
        && !(gameboard[dR][dC].getTerrain() instanceof River)){
            val= true;
        }
        else{
            System.out.println("INVALID MOVE crossing the river");
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



    /**
     * This method checks if jump on river will have a mouse in the way
     * @param gameboard 2D array of Tiles in the gameboard
     * @param sR the Row position of the mover on the gameboard
     * @param sC the Col position of the mover on the gameboard
     * @param dR the Row position of the destination on the gameboard
     * @param dC the Col position of the destination on the gameboard
     * @return true if the move is valid, false if otherwise
     */
        public static boolean checkRiver(Tile[][] gameboard, int sR, int sC, int dR, int dC){
        boolean val = false;
        int count = 0;

        if(gameboard[dR][dC].getAnimal() == null || gameboard[dR][dC].getAnimal().getRank() <= gameboard[sR][sC].getAnimal().getRank()){
            if(sR == dR){
                if(sC < dC){ //RIGHT
                    while(gameboard[sR][sC+1].getTerrain() instanceof River && gameboard[sR][sC+1].getAnimal() == null && sC < dC){
                        count++;
                        sC++;
                    }
                }
                else{ //LEFT 
                    while(gameboard[sR][sC-1].getTerrain() instanceof River && gameboard[sR][sC-1].getAnimal() == null && sC > dC){
                        count++;
                        sC--;
                    }
                }
                if(count == 3)
                    val = true;
            }
            else if(sC == dC){
                if(sR < dR){ //Down
                    while(gameboard[sR+1][sC].getTerrain() instanceof River && gameboard[sR+1][sC].getAnimal() == null && sR < dR){
                        count++;
                        sR++;
                    }
                }
                else{//UP
                    while(gameboard[sR-1][sC].getTerrain() instanceof River && gameboard[sR-1][sC].getAnimal() == null && sR > dR){
                        count++;
                        sR--;
                    }
                }
                if(count == 2)
                    val = true;
            }
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
    public static boolean validJump(Tile[][] gameboard, int sR, int sC, int dR, int dC){
        boolean val = false;

        if((sR-3 == dR) && (sC == dC)){ //UP
            System.out.println("UP!");
            if(checkRiver(gameboard, sR, sC, dR, dC))
                val = true;
        }
        else if((sR+3 == dR) && (sC == dC)){ //DOWN
            System.out.println("DOWN!");
            if(checkRiver(gameboard, sR, sC, dR, dC))
                val = true;
        }
        else if((sR == dR) && (sC-4 == dC)){ //LEFT
            System.out.println("LEFT!");
            if(checkRiver(gameboard, sR, sC, dR, dC))
                val = true;
        }
        else if((sR == dR) && (sC+4 == dC)){ //RIGHT
            System.out.println("RIGHT!");
            if(checkRiver(gameboard, sR, sC, dR, dC))
                val = true;
        }
        else
            System.out.println("INVALID");

        return val;
    }
}
