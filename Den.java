/** This class a subclass of Terain
* @author Alyssa Ysabelle Meneses
* @author Lind Matthew Tan
* @version 1.0
*/
public class Den extends Terrain{
    private final Player PLAYER;

    /** 
     * Constructor for Den
     * @param x x pos
     * @param y y pos
     * @param p player owner
     */
    public Den(int x, int y, Player p){
        super(x,y);
        PLAYER = p;
    }

    /** 
     * returns owner of the Den
     * @return player owner of the Den
     */
    public Player getPlayer(){
        return PLAYER;
    }

}