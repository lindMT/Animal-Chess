/** This class is to facilitate the gamephase
* @author Alyssa Ysabelle Meneses
* @author Lind Matthew Tan
* @version 1.0
*/
public class GamePhase {
    private static Player playerRed;
    private static Player playerBlue;
    private static Player playerWinner;
    private static Board board;


    /**
     * This method displays  a message for the winner
     * @param winner the winning player
     */
    public static void displayWinner(Player winner){
        System.out.println("Congrats for Winning!     "+winner.getName()+"/"+winner.getColor()+"     Congrats for Winning!");
        playerWinner=winner;
    }
    /**
     * This method returns the winner
     * @return winning player
     */
    public static Player getWinner(){
        return playerWinner;
    }
    /**
     * This method returns the board
     * @return gameboard
     */
    public static Board getBoard(){
        return board;
    }
    
    /**
     * This method initializes the players
     * @param player1 player to go first
     * @param player2 player to go second
     */
    public static void initPlayers (Player player1, Player player2){
        if (player1.getColor().equalsIgnoreCase("Red")){
            playerRed = player1;
            playerBlue = player2;
        }
        else {
            playerRed = player2;
            playerBlue = player1;
        }
    }

    /**
     * This method initializes the gamephase
     * @param player1 player to go first
     * @param player2 player to go second
     */
    public static void gameStart(Player player1, Player player2){
        
        initPlayers(player1, player2); //initialize players
        board = new Board(playerRed, playerBlue);
    
    }

    /**
     * This method checks if the moving piece selected is valid
     * @param x moving piece x pos
     * @param y moving piece y pos
     * @return true if valid, false if not
     */
    public static boolean isValidMovingPiece(int x, int y){
        if (board.getTile(x, y).getAnimal()==null){
            System.out.println("IVMP invalid empty tile, cannot move");
            return false;
        }
        else if(board.getTile(x, y).getAnimal()!=null && board.getTile(x, y).getAnimal().getOwner().getTurn()==true){
                if (board.getTile(x, y).getAnimal() instanceof Mouse) {///////////
                    System.out.println("IVMP chosen to move a MOUSE");
                }
                else if (board.getTile(x, y).getAnimal() instanceof Elephant) {////////////
                    System.out.println("IVMP chosen to move an ELEPHANT");
                }
                else if (board.getTile(x, y).getAnimal() != null) {///////////
                    System.out.println("IVMP chose to move a normal ANIMAL");
                }
            
           
            return true;
        }
        else{
            System.out.println("IVMP invalid moving piece, thats not your piece");
        }
        return false;
    }
    /**
     * This method facilitates the turn of the game
     * @param x moving piece x pos
     * @param y moving piece y pos
     * @param dX destination piece x pos
     * @param dY destination piece y pos
     * @return true if valid move and board updated, false if not
     */
    public static boolean turn(int x, int y, int dX, int dY){

        boolean moved = false;
        
                if(playerRed.getTurn() == true)
                    System.out.println("Player " + playerRed.getName() + "'s turn! [" + playerRed.getColor() + "]");
                else if(playerBlue.getTurn() == true)
                    System.out.println("Player " + playerBlue.getName() + "'s turn![" + playerBlue.getColor() + "]");

                System.out.println("trying to move "+x+" "+y+ " into "+dX+" "+dY);
                //clicks a tile
                //for checking purposes


                moved = Board.animalMove(x, y, dX, dY);

                if(moved==true){
                    //switch turn
                    playerBlue.changeTurn();
                    playerRed.changeTurn();
                }
                else{
                    System.out.println("invalid destination tile (gamephase)");
                }

                board.display();
                System.out.println("==================================\n");

        if(board.checkWinner() == true) //check if may winner after turn
        {
            if(playerBlue.getTurn()==false)
                displayWinner(playerBlue); 
            else
                displayWinner(playerRed); 
        }
        return moved;
    }

}
