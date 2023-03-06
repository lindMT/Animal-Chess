/**
 * this class is a subclass of Terrain
 * @author Alyssa Ysabellele Meneses
 * @author Lind Matthew Tan
 * @version 1.0
 */
public class Trap extends Terrain{
    private Player player;

    /**
     * Constructor for Trap
     * @param x x position of the terrain in the board
     * @param y y position of the terrain in the board
     * @param player owner of the trap
     */
    public Trap(int x, int y, Player player){
        super(x, y);
        this.player = player;
    }

    /**
     * gets the player owner
     * @return player owner of the Trap
     */
    public Player getPlayer(){
        return player;
    }
}
