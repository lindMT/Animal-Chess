/** This class is the board, a Tile[][]
* @author Alyssa Ysabelle Meneses
* @author Lind Matthew Tan
* @version 1.0
*/
public class Board {
    private static Tile[][] gameboard;

    /**
     * This constructor initializes the pieces of the board.
     * @param red player with red pieces on the board
     * @param blue player with blue pieces on the board
     */
    public Board(Player red, Player blue){
        gameboard = new Tile[7][9];

        gameboard[0][0] = new Tile(new Grass(0, 0), new AnimalCanJump("Tiger", 6, "[T]", red));
        gameboard[1][1] = new Tile(new Grass(1, 1), new Animal("Cat", 2, "[C]", red));
        gameboard[0][2] = new Tile(new Grass(0, 2), new Elephant("Elephant", 8, "[E]", red));
        gameboard[2][2] = new Tile(new Grass(2, 2), new Animal("Wolf", 3, "[W]", red));
        gameboard[4][2] = new Tile(new Grass(4, 2), new Animal("Leopard", 5, "[L]", red));
        gameboard[5][1] = new Tile(new Grass(5, 1), new Animal("Dog", 4, "[D]", red));
        gameboard[6][0] = new Tile(new Grass(6, 0), new AnimalCanJump("Lion", 7, "[L]", red));
        gameboard[6][2] = new Tile(new Grass(6, 2), new Mouse("Mouse", 1, "[M]", red));

        gameboard[6][8] = new Tile(new Grass(6, 8), new AnimalCanJump("Tiger", 6, "[T]", blue));
        gameboard[5][7] = new Tile(new Grass(5, 7), new Animal("Cat", 2, "[C]", blue));
        gameboard[6][6] = new Tile(new Grass(6, 6), new Elephant("Elephant", 8, "[E]", blue));
        gameboard[4][6] = new Tile(new Grass(4, 6), new Animal("Wolf", 3, "[W]", blue));
        gameboard[2][6] = new Tile(new Grass(2, 6), new Animal("Leopard", 5, "[L]", blue));
        gameboard[1][7] = new Tile(new Grass(1, 7), new Animal("Dog", 4, "[D]", blue));
        gameboard[0][8] = new Tile(new Grass(0, 8), new AnimalCanJump("Lion", 7, "[L]", blue));
        gameboard[0][6] = new Tile(new Grass(0, 6), new Mouse("Mouse", 1, "[M]", blue));

        for(int i = 1; i <= 2; i++)
            for(int j = 3; j <= 5; j++)
                gameboard[i][j] = new Tile(new River(i, j));

        for(int i = 4; i <= 5; i++)
            for(int j = 3; j <= 5; j++)
                gameboard[i][j] = new Tile(new River(i, j));

        gameboard[3][0] = new Tile(new Den(3, 0, red));
        gameboard[3][8] = new Tile(new Den(3, 8, blue));

        gameboard[2][0] = new Tile(new Trap(2, 0, red));
        gameboard[3][1] = new Tile(new Trap(3, 1, red));
        gameboard[4][0] = new Tile(new Trap(4, 0, red));

        gameboard[2][8] = new Tile(new Trap(2, 8, blue));
        gameboard[3][7] = new Tile(new Trap(3, 7, blue));
        gameboard[4][8] = new Tile(new Trap(4, 8, blue));

        for(int i = 0; i < 7; i++)
            for(int j = 0; j < 9; j++)
                if(gameboard[i][j] == null)
                    gameboard[i][j] = new Tile(new Grass(i, j));
    }

    /**
     * This method displays the board on the console
     */
    public void display(){
        for(int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                if (gameboard[i][j].getAnimal() != null)
                    System.out.print(gameboard[i][j].getAnimal().getEmoji()); //sample - change to gui
                else
                    System.out.print("[ ]");
            }
            System.out.println();
        }
    }

    /**
     * This method returns the tile base on the coordinates givem
     * @param x row of the tile
     * @param y column of the tile
     * @return tile on the given location
     */
    public Tile getTile(int x, int y){
        return gameboard[x][y];
    }

    /**
     * This method moves the piece to its destination
     * @param sR row where the animal is originally placed
     * @param sC column where the animal is originally placed
     * @param dR row where the animal is to be placed
     * @param dC column where the animal is to be placed
     */
    public static void move(int sR, int sC, int dR, int dC){
        gameboard[dR][dC].setAnimal(gameboard[sR][sC].getAnimal());
        gameboard[sR][sC].setAnimal(null);
    }

    /**
     * This method checks if move is valid according to the board, and calls other methods to check if the move is valid
     * @param sR row where the animal is originally placed
     * @param sC column where the animal is originally placed
     * @param dR row where the animal is to be placed
     * @param dC column where the animal is to be placed
     * @return returns true if valid move, false if not
     */
    public static boolean animalMove(int sR, int sC, int dR, int dC){

        if(gameboard[dR][dC].getTerrain() instanceof Den){
            if(gameboard[sR][sC].getAnimal().getOwner() == ((Den)gameboard[dR][dC].getTerrain()).getPlayer()){
                return false;
            }
        }

        if(gameboard[sR][sC].getAnimal().getOwner().getTurn() && (gameboard[dR][dC].getAnimal()==null 
        || gameboard[dR][dC].getAnimal().getOwner() != gameboard[sR][sC].getAnimal().getOwner())){
        // above is to check if correct turn and destination is not same owner

            if(gameboard[sR][sC].getAnimal().isValidMove(gameboard, sR, sC, dC, dR)){//if valid move
                move(sR, sC, dR, dC);
                return true;
            }
            else 
                return false;

        }

        else{
            System.out.println("INVALID! wrong piece turn or cannot go to same piece");
        }
        return false;
    }

    

    /**
     * This method counts the number of animals the player has on the board
     * @return true, if there are still piece colors from both; else return false
     */
    public boolean countPiece(){
        int countRed = 0;
        int countBlue = 0;

        for(int i = 0; i < 7; i++)
            for(int j = 0; j < 9; j++)
                if(gameboard[i][j].getAnimal() != null ){
                    if (gameboard[i][j].getAnimal().getOwner().getColor().equalsIgnoreCase("Red"))
                        countRed++;
                }
                    

        if (countRed==0)
            return false;//Blue wins

        for(int i = 0; i < 7; i++)
            for(int j = 0; j < 9; j++)
                if(gameboard[i][j].getAnimal() != null ){
                    if (gameboard[i][j].getAnimal().getOwner().getColor().equalsIgnoreCase("Blue"))
                        countBlue++;
                }

        if (countBlue == 0)
            return false;//Red wins

        return true;// no winnner 
    }

    /**
     * This method checks if there is a winner in the game
     * @return true if there is a winner, false if there is not
     */
    public boolean checkWinner(){
        if(gameboard[3][0].getAnimal() != null) //check den of red
            return true;
        else if(gameboard[3][8].getAnimal() != null) //check den of blue
            return true;
        else if(countPiece()==false) //pieces
            return true;

        return false;
    }
    
}
