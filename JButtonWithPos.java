import java.awt.image.BufferedImage;
import javax.swing.*;
/** This class is the subclass of JButton
* @author Alyssa Ysabelle Meneses
* @author Lind Matthew Tan
* @version 1.0
*/
public class JButtonWithPos extends JButton{
    private int row;
    private int col;

    /**
     * constructor for JButtonWithPos
     * @param row row pos of the button
     * @param col col pos of the button
     */
    public JButtonWithPos(int row, int col){
        this.row=row;
        this.col=col;
    }
    /** 
     * this method gets row pos
     * @return row pos of the button
     */
    public int getRow(){
        return row;
    }

    /** 
     * this method gets col pos
     * @return col pos of the button
     */
    public int getCol(){
        return col;
    }

    /** 
     * this method makes the icon transparent (removes)
     */
    public void removeIcon(){
        this.setIcon(new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
    }
}