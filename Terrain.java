/**
 * this class is the parent class for River, Den, and Grass
 * @author Alyssa Ysabellele Meneses
 * @author Lind Matthew Tan
 * @version 1.0
 */
public class Terrain {
    private final int X;
    private final int Y;

    /**
     * Constructor for terrain
     * @param x x position of the terrain in the board
     * @param y y position of the terrain in the board
     */
    public Terrain (int x, int y)
    {
        X = x;
        Y = y;
    }

    /**
     * gets x pos
     * @return x position of the terrain in the board
     */
    public int getX(){
        return X;
    }

    /**
     * gets y pos
     * @return y position of the terrain in the board
     */
    public int getY(){
        return Y;
    }
}